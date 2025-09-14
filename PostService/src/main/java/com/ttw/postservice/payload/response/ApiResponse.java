package com.ttw.postservice.payload.response;

public record ApiResponse<T>(
        boolean success,
        String message,
        T data) {

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true,"Request Successful",data);
    }

    public static <T> ApiResponse<T> successs() {
        return new ApiResponse<>(true,"RequestSuccessFul",null);
    }

    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>(true,message,data);
    }

    public static <T> ApiResponse<T> success(String message) {
        return new ApiResponse<>(true,message,null);
    }

    public static <T> ApiResponse<T> fail(String message) {
        return new ApiResponse<>(false,message,null);
    }
}
