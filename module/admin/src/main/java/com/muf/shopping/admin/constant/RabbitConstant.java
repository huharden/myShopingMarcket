package com.muf.shopping.admin.constant;

/**
 * @author hutao
 * @date 2018/12/13
 */

public class RabbitConstant  {
    //交换机名称
    public final static String SYS_USER_QUEUE_NAME = "exchange_test";
    //队列
    public final static String QUEUE_TRANSACTION = "queue_transaction";
    public final static String QUEUE_CONTRACT = "queue_contract";
    public final static String QUEUE_QUALIFICATION = "queue_qualification";
    //路由key
    public final static String RK_TRANSACTION = "transaction";
    public final static String RK_CONTRACT = "contract";
    public final static String RK_QUALIFICATION = "qualification";
    public final static String EXCHANGE= "qualification";


}
