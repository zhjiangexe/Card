package com.jiang.app.dto;

public class ResponseUtil {


//  private static ResponseEntity<ApiResponse> generalOK(ApiResponse apiResponse) {
//    return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
//  }
//
//  private static ResponseEntity<ApiResponse> generalUnAuthor(ApiResponse apiResponse) {
//    return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.UNAUTHORIZED);
//  }
//
//  /**
//   * 未授权认证成功
//   *
//   * @param msg
//   * @return
//   */
//  public static ResponseEntity<ApiResponse> unAuthor(String msg) {
//    return generalUnAuthor(new ApiResponse(msg));
//  }
//
//  /**
//   * 成功返回(只包含msg和code)
//   *
//   * @param msg
//   * @return
//   */
//  public static ResponseEntity<ApiResponse> success(String msg) {
//    return generalOK(new ApiResponse(msg, "RESCODE_SUCCESS"));
//  }
//
//  /**
//   * 成功返回（包含msg,code,Obj）
//   *
//   * @param msg
//   * @param object
//   * @return
//   */
//  public static ResponseEntity<ApiResponse> success(String msg, Object object) {
//    ApiResponse apiResponse = new ApiResponse(msg, "RESCODE_SUCCESS");
//    apiResponse.setData(object);
//    return generalOK(apiResponse);
//  }
//
//  /**
//   * 不存在
//   *
//   * @return
//   */
//  public static ResponseEntity<ApiResponse> notExist() {
//    ApiResponse apiResponse = new ApiResponse("不存在", "RESCODE_NOEXIST");
//    return generalOK(apiResponse);
//  }
//
//  public static ResponseEntity<ApiResponse> error() {
//    ApiResponse apiResponse = new ApiResponse("操作失败了", "RESCODE_ERROR");
//    return generalOK(apiResponse);
//  }
//
//  /**
//   * 请求出现异常信息
//   *
//   * @param msg
//   * @return
//   */
//  public static ResponseEntity<ApiResponse> exception(String msg) {
//    return generalOK(new ApiResponse(msg, "RESCODE_EXCEPTION"));
//  }
//
//  /**
//   * 未知异常
//   *
//   * @return
//   */
//  public static ResponseEntity<ApiResponse> unKonwException() {
//    return exception("请稍后再试！");
//  }
//
//  /**
//   * 自定义返回code和msg
//   *
//   * @param msg
//   * @param code
//   * @return
//   */
//  public static ResponseEntity<ApiResponse> custom(String msg, String code) {
//    return generalOK(new ApiResponse(msg, code));
//  }
}