package cn.jing.gateway.mapping;


/**
 * 作用 ：限定 HTTP 请求方法类型，确保路由规则的规范性。
 */
public enum HttpCommandType {

    UNKNOWN,
    GET,
    POST,
    PUT,
    DELETE

}
