package katest.dipenpradhan.com.katest_dipen.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface KABadgeAPI {

  @GET("badges")
  Call<ResponseBody> getBadges();

  @GET("badges/categories")
  Call<ResponseBody> getCategories();


}
