package com.example.classifiedapp.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.classifiedapp.data.network.Result
import com.example.classifiedapp.utils.Messages.getNoDataFound
import com.example.classifiedapp.utils.Messages.getNoDataSpecified
import kotlinx.coroutines.Dispatchers
import org.json.JSONObject
import retrofit2.Response
import java.lang.Exception

abstract class BaseRepo {
    protected fun <T> getNetworkResult(call: suspend () -> Response<T>): LiveData<Result<T>> =
        liveData(Dispatchers.IO) {
            try {
                val response = call.invoke()
                    emit(gatherResult(response))

            } catch (e: Exception) {
                emit(Result.Error<T>(""))
            }
        }

    private fun <T> gatherResult(response: Response<T>): Result<T> {
        return if(response.isSuccessful){
            val body = response.body()
            if(body != null) Result.Success(body)
            else Result.Error(getNoDataFound())
        }else {
            Result.Error("${JSONObject(response.errorBody()?.string())[" message "] ?: getNoDataSpecified()}")
        }
    }
}