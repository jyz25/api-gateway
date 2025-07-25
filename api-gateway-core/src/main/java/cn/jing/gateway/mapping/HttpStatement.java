package cn.jing.gateway.mapping;


/**
 * - 作用 ：封装一条完整的路由规则，定义“HTTP 请求如何映射到后端服务”。
 * - 使用场景 ：通过 MapperRegistry.addMapper(httpStatement) 注册到系统，供请求路由时查询。
 */
public class HttpStatement {

    /** 应用名称； */
    private String application;
    /** 服务接口；RPC、其他 */
    private String interfaceName;
    /** 服务方法；RPC#method */
    private String methodName;
    /** 网关接口 */
    private String uri;
    /** 接口类型；GET、POST、PUT、DELETE */
    private HttpCommandType httpCommandType;

    public HttpStatement(String application, String interfaceName, String methodName, String uri, HttpCommandType httpCommandType) {
        this.application = application;
        this.interfaceName = interfaceName;
        this.methodName = methodName;
        this.uri = uri;
        this.httpCommandType = httpCommandType;
    }

    public String getApplication() {
        return application;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getUri() {
        return uri;
    }

    public HttpCommandType getHttpCommandType() {
        return httpCommandType;
    }

}
