package entity;

public class Result {


 // true/false 成功或者失败
 private boolean flag;
 // 自己规定状态码  20000表示成功 20001表示失败
 private Integer code;
 // 提示信息
 private String message;
 // 数据，查询方法返回的数据
 private Object data;

 // 无参数数据
 public Result() {
 }

 // 增删改返回值
 public Result(boolean flag, Integer code, String message) {
  this.flag = flag;
  this.code = code;
  this.message = message;
 }

 // 查询的返回值
 public Result(boolean flag, Integer code, String message, Object data) {
  this.flag = flag;
  this.code = code;
  this.message = message;
  this.data = data;
 }

 public boolean isFlag() {
  return flag;
 }

 public void setFlag(boolean flag) {
  this.flag = flag;
 }

 public Integer getCode() {
  return code;
 }

 public void setCode(Integer code) {
  this.code = code;
 }

 public String getMessage() {
  return message;
 }

 public void setMessage(String message) {
  this.message = message;
 }

 public Object getData() {
  return data;
 }

 public void setData(Object data) {
  this.data = data;
 }
}
