package katest.dipenpradhan.com.katest_dipen.api;

import android.app.Activity;
import android.content.ContentValues;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

import katest.dipenpradhan.com.katest_dipen.database.DBConstants;
import katest.dipenpradhan.com.katest_dipen.database.DBProvider;
import katest.dipenpradhan.com.katest_dipen.entity.Badge;
import katest.dipenpradhan.com.katest_dipen.entity.Category;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by dipenpradhan on 2/8/16.
 */
public class APIManager {

    private static final Retrofit mRetrofit = new Retrofit.Builder()
            .baseUrl("http://www.khanacademy.org/api/v1/")
            .build();
    private static final KABadgeAPI badgeAPI = mRetrofit.create(KABadgeAPI.class);

    private static final ObjectMapper mObjectMapper = new ObjectMapper();

    public static void getBadges(@NonNull final Activity context, final int requestId, @Nullable final APIListener<List<Badge>> listener) {
        if (listener != null) listener.onBegin(requestId);
        badgeAPI.getBadges().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, final Response<ResponseBody> response) {


                if (response.body() == null || response.body().byteStream() == null) {
                    if (listener != null) {
                        listener.onFailure(requestId, APIResult.FailureType.PARSE, null);
                    }
                    return;
                }
                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... params) {
                        try {
                            List<Badge> badgeList = mObjectMapper.readValue(response.body().byteStream(),
                                    new TypeReference<List<Badge>>() {
                                    });

                            final APIResult result = new APIResult<List<Badge>>(requestId, response.code(), badgeList);
                            if (listener != null) {
                                context.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        listener.onSuccess(requestId, result);
                                    }
                                });
                            }
                            ContentValues[] badgeCVs = new ContentValues[badgeList.size()];

                            for (int i = 0; i < badgeList.size(); i++) {
                                Badge b = badgeList.get(i);
                                badgeCVs[i] = b.toContentValues();
                            }

                            context.getContentResolver().
                                    bulkInsert(
                                            Uri.withAppendedPath(DBConstants.CONTENT_URI, DBProvider.DB_URIs.BADGE.getPath()),
                                            badgeCVs);
                        } catch (final IOException e) {
                            if (listener != null) {
                                context.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        listener.onFailure(requestId, APIResult.FailureType.PARSE, e);
                                    }
                                });
                            }
                            e.printStackTrace();
                        }
                        return null;
                    }
                }.execute();

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                if (listener != null) {
                    listener.onFailure(requestId, APIResult.FailureType.CONNECTION, t);
                }
            }
        });

    }


    public static void getCategories(@NonNull final Activity context, final int requestId, @Nullable final APIListener<List<Category>> listener) {
        if (listener != null) listener.onBegin(requestId);

        badgeAPI.getCategories().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, final Response<ResponseBody> response) {
                if (response.body() == null || response.body().byteStream() == null) {
                    if (listener != null) {
                        listener.onFailure(requestId, APIResult.FailureType.PARSE, null);
                    }
                    return;
                }
                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... params) {

                        try {
                            List<Category> categoryList = mObjectMapper.readValue(response.body().byteStream(),
                                    new TypeReference<List<Category>>() {
                                    });

                            final APIResult result = new APIResult<List<Category>>(requestId, response.code(), categoryList);
                            if (listener != null) {
                                context.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        listener.onSuccess(requestId, result);
                                    }
                                });
                            }

                            ContentValues[] categoryCVs = new ContentValues[categoryList.size()];

                            for (int i = 0; i < categoryList.size(); i++) {
                                Category c = categoryList.get(i);
                                categoryCVs[i] = c.toContentValues();
                            }

                            context.getContentResolver().
                                    bulkInsert(
                                            Uri.withAppendedPath(DBConstants.CONTENT_URI, DBProvider.DB_URIs.CATEGORY.getPath()),
                                            categoryCVs);

                        } catch (final IOException e) {
                            if (listener != null) {
                                context.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        listener.onFailure(requestId, APIResult.FailureType.PARSE, e);
                                    }
                                });
                            }
                            e.printStackTrace();
                        }
                        return null;
                    }
                }.execute();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                if (listener != null) {
                    listener.onFailure(requestId, APIResult.FailureType.CONNECTION, t);
                }
            }
        });

    }

}
