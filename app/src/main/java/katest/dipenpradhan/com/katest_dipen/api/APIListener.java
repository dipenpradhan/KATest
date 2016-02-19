package katest.dipenpradhan.com.katest_dipen.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by dipenpradhan on 2/8/16.
 */
public interface APIListener<T> {

    void onBegin(int requestId);
    void onSuccess(int requestId, APIResult<T> apiResult);
    void onFailure(int requestId, @NonNull APIResult.FailureType failureType, @Nullable  Throwable t);
}
