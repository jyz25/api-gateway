package cn.jing.gateway.bind;

/**
 * @description 统一泛化调用接口
 *
 * generic(通用的、一般的) ： 泛化调用（genric invocation）
 * reference ： 对远程服务的引用（reference to a remote service）
 */
public interface IGenericReference {

    String $invoke(String args);

}