package cn.jing.gateway.session;

import cn.jing.gateway.bind.IGenericReference;

/**
 * 会话接口 - 定义请求处理的标准协议：
 * - `get` ：处理HTTP请求的核心方法
 * - `getMapper` ：获取URI对应的服务映射器
 * - `getConfiguration` ：获取全局配置
 */
public interface GatewaySession {

    Object get(String uri, Object parameter);

    IGenericReference getMapper(String uri);

    Configuration getConfiguration();

}