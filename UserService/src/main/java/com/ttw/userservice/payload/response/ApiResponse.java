package com.ttw.userservice.payload.response;

public record ApiResponse<T> (
        boolean success,
        String message,
        T data
) {
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true,"Request Successful",data);
    }
    public static <T> ApiResponse<T> success(String message,T data) {
        return new ApiResponse<>(true,message,data);
    }
    public static <T> ApiResponse<T> failure(String message) {
        return new ApiResponse<>(false,message,null);
    }

}
