package cn.jing.gateway.bind;

/**
 * - 作用 ：定义网关对外暴露的泛化调用接口，所有后端服务调用都通过此接口执行。
 * - 特点 ：屏蔽后端服务差异（如 Dubbo、HTTP 等），提供统一调用方式。
 */
public interface IGenericReference {

    String $invoke(String args);

}