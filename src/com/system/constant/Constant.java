package com.system.constant;

public class Constant {

	public static final String SESSION_KEY = "login-user";

    public static final String  POS_CONTENT_ENCODING                    = "GBK";
    public static final String  ANDROID_CONTENT_ENCODING                = "GBK";
    public static final String  ANDROID_CONTENT_ENCODING_UTF                = "UTF-8";
    public static final String  HTTP_METHOD_GET                         = "GET";
    public static final String  HTTP_METHOD_POST                        = "POST";

    public static final String  ACTION_ADD                              = "add";
    public static final String  ACTION_MODIFY                           = "modify";
    public static final String  OPERATE_SUCCESS                         = "1";
    public static final String  UPLOAD_PATH_CONFIGNAME                  =
                                                                        "uploadPathConfig.properties";
    public static final String  MAIN_CONFIGNAME                         = "config.properties";

    public static final String  DEFAULT_FLOAT_TO_STRING_VALUE           = "0.0F";

    public static final int     AGREE_GREENWAY_FLAG                     = 1;
    public static final int     NEW_GREENWAY_FLAG                       = 0;
    public static final int     REFUSE_GREENWAY_FLAG                    = 2;

    public static final int     QUERY_NEW_GREENWAY                      = 1;
    public static final int     QUERY_REPLY_GREENWAY                    = 2;
    public static final int     CANCEL_NEW_GREENWAY_FLAG                = 3;

    public static final String  IS_NOT_DUPLICATED                       = "0";
    public static final String  IS_DUPLICATED                           = "1";

    public static final String  IS_VALID_DATA_RECORD                    = "0";

    public static final String  BUSINESSWORKER_MONDAY                   = "2";
    public static final String  BUSINESSWORKER_TUESDAY                  = "3";
    public static final String  BUSINESSWORKER_WEDNSDAY                 = "4";
    public static final String  BUSINESSWORKER_THURSDAY                 = "5";
    public static final String  BUSINESSWORKER_FRIDAY                   = "6";
    public static final String  BUSINESSWORKER_SATURDAY                 = "7";
    public static final String  BUSINESSWORKER_SUNDAY                   = "1";
    public static final Integer BUSINESSWORKER_NOW_MONTH                = 0;
    public static final Integer BUSINESSWORKER_BEFORE_ONE_MONTH         = -1;
    public static final Integer BUSINESSWORKER_BEFORE_TWO_MONTH         = -2;
    public static final Integer BUSINESSWORKER_BEFORE_THREE_MONTH       = -3;
    public static final Integer BUSINESSWORKER_NEXT_MONTH               = 1;
    public static final Long    FLAG_TERMINAL                           = 10L;

    public static final String  ORDERSTK_ORDER_SMS_SERVICE_CODE         = "01";
    public static final String  ORDERSTK_STORAGE_SMS_SERVICE_CODE       = "02";
    public static final String  SENDSTK_SENDING_FINISH_SMS_SERVICE_CODE = "03";
    public static final String  SENDSTK_SENDING_UPDATE_SERVICE_CODE     = "04";
    public static final String  SENDSTK_ORDER_SMS_SERVICE_CODE          = "05";
    public static final String  SENDSTK_STORAGE_SMS_SERVICE_CODE        = "06";

    public static final String  RIGHT_SMALL_BRACKET                     = ")";
    public static final String  LEFT_SMALL_BRACKET                      = "(";
    public static final String  RIGHT_BIG_BRACKET                       = "}";
    public static final String  LEFT_BIG_BRACKET                        = "{";
    public static final String  RIGHT_MIDDLE_BRACKET                    = "]";
    public static final String  LEFT_MIDDLE_BRACKET                     = "[";
    public static final String  REGEX_START_STR                         = "^";
    public static final String  REGEX_END_STR                           = "$";
    public static final String  REGEX_PLUS_STR                          = "+";
    public static final String  XINGHAO_REGEX_STR                       = "\\*";                                                     // asterisk
    // 星号
    public static final String  JINGHAO_REGEX_STR                       = "#";
    public static final String  COUNTER_REGEX_STR                       = "(\\d){3,3}";
    public static final String  TERMINALID_REGEX_STR                    = "(\\d){1,7}";
    public static final String  ORDER_CODE_REGEX_STR                    = "(\\d){1,16}";
    public static final String  PRODUCT_CODE_REGEX_STR                  = "(\\d){1,3}";
    public static final String  ORDERNUM_REGEX_STR                      =
                                                                        "(((\\d){1,6})|((\\d){1,5}.(\\d){1,2}))";
    public static final String  MONTH_REGEX_STR                         =
                                                                        "((0[1-9]{1})|(1[1-2]{1}))";
    public static final String  DAY_REGEX_STR                           =
                                                                        "((0[1-9]{1})|((1|2)(\\d){1,1})|(3[0-1]{1,1}))";
    public static final String  HOUR_REGEX_STR                          =
                                                                        "(([0-1]{1,1}(\\d){1,1})|(2[0-4]{1,1}))";
    public static final String  MONTH_DAY_HOUR_TEGEX_STR                =
                                                                        Constant.LEFT_SMALL_BRACKET
                                                                        + Constant.MONTH_REGEX_STR
                                                                        + Constant.DAY_REGEX_STR
                                                                        + Constant.HOUR_REGEX_STR
                                                                        + Constant.RIGHT_SMALL_BRACKET;
    public static final String  MONEY_REGEX_STR                         =
                                                                        "(((\\d){1,7})|((\\d){1,5}.(\\d){2})|((\\d){1,6}.(\\d){1}))";
    public static final String  ORDER_STK_ORDER_SMS_REGEX_STR           =
                                                                        Constant.REGEX_START_STR
                                                                        + Constant.LEFT_SMALL_BRACKET
                                                                        + Constant.ORDERSTK_ORDER_SMS_SERVICE_CODE
                                                                        + Constant.XINGHAO_REGEX_STR
                                                                        + Constant.COUNTER_REGEX_STR
                                                                        + Constant.XINGHAO_REGEX_STR
                                                                        + Constant.TERMINALID_REGEX_STR
                                                                        + Constant.XINGHAO_REGEX_STR
                                                                        + Constant.MONTH_DAY_HOUR_TEGEX_STR
                                                                        + Constant.JINGHAO_REGEX_STR
                                                                        + Constant.RIGHT_SMALL_BRACKET
                                                                        + Constant.LEFT_SMALL_BRACKET
                                                                        + Constant.PRODUCT_CODE_REGEX_STR
                                                                        + Constant.XINGHAO_REGEX_STR
                                                                        + Constant.ORDERNUM_REGEX_STR
                                                                        + Constant.JINGHAO_REGEX_STR
                                                                        + Constant.RIGHT_SMALL_BRACKET
                                                                        + Constant.REGEX_PLUS_STR
                                                                        + Constant.REGEX_END_STR;
    public static final String  ORDER_STK_MIN_STORAGE_SMS_REGEX_STR     =
                                                                        Constant.REGEX_START_STR
                                                                        + Constant.LEFT_SMALL_BRACKET
                                                                        + Constant.ORDERSTK_STORAGE_SMS_SERVICE_CODE
                                                                        + Constant.XINGHAO_REGEX_STR
                                                                        + Constant.COUNTER_REGEX_STR
                                                                        + Constant.XINGHAO_REGEX_STR
                                                                        + Constant.TERMINALID_REGEX_STR
                                                                        + Constant.XINGHAO_REGEX_STR
                                                                        + Constant.PRODUCT_CODE_REGEX_STR
                                                                        + Constant.XINGHAO_REGEX_STR
                                                                        + Constant.ORDERNUM_REGEX_STR
                                                                        + Constant.JINGHAO_REGEX_STR
                                                                        + Constant.RIGHT_SMALL_BRACKET
                                                                        + Constant.REGEX_END_STR;
    public static final String  SEND_STK_SEND_FINISH_SMS_REGEX_STR      =
                                                                        Constant.REGEX_START_STR
                                                                        + Constant.LEFT_SMALL_BRACKET
                                                                        + Constant.SENDSTK_SENDING_FINISH_SMS_SERVICE_CODE
                                                                        + Constant.XINGHAO_REGEX_STR
                                                                        + Constant.COUNTER_REGEX_STR
                                                                        + Constant.XINGHAO_REGEX_STR
                                                                        + Constant.ORDER_CODE_REGEX_STR
                                                                        + Constant.JINGHAO_REGEX_STR
                                                                        + Constant.RIGHT_SMALL_BRACKET
                                                                        + Constant.REGEX_END_STR;
    public static final String  SEND_STK_SEND_UPDATE_SMS_REGEX_STR      =
                                                                        Constant.REGEX_START_STR
                                                                        + Constant.LEFT_SMALL_BRACKET
                                                                        + Constant.SENDSTK_SENDING_UPDATE_SERVICE_CODE
                                                                        + Constant.XINGHAO_REGEX_STR
                                                                        + Constant.COUNTER_REGEX_STR
                                                                        + Constant.XINGHAO_REGEX_STR
                                                                        + Constant.ORDER_CODE_REGEX_STR
                                                                        + Constant.JINGHAO_REGEX_STR
                                                                        + Constant.RIGHT_SMALL_BRACKET
                                                                        + Constant.LEFT_SMALL_BRACKET
                                                                        + Constant.PRODUCT_CODE_REGEX_STR
                                                                        + Constant.XINGHAO_REGEX_STR
                                                                        + Constant.ORDERNUM_REGEX_STR
                                                                        + Constant.XINGHAO_REGEX_STR
                                                                        + Constant.ORDERNUM_REGEX_STR
                                                                        + Constant.XINGHAO_REGEX_STR
                                                                        + Constant.MONEY_REGEX_STR
                                                                        + Constant.JINGHAO_REGEX_STR
                                                                        + Constant.RIGHT_SMALL_BRACKET
                                                                        + Constant.REGEX_PLUS_STR
                                                                        + Constant.REGEX_END_STR;
    public static final String  SEND_STK_ORDER_SMS_REGEX_STR            =
                                                                        Constant.REGEX_START_STR
                                                                        + Constant.LEFT_SMALL_BRACKET
                                                                        + Constant.SENDSTK_ORDER_SMS_SERVICE_CODE
                                                                        + Constant.XINGHAO_REGEX_STR
                                                                        + Constant.COUNTER_REGEX_STR
                                                                        + Constant.XINGHAO_REGEX_STR
                                                                        + Constant.TERMINALID_REGEX_STR
                                                                        + Constant.JINGHAO_REGEX_STR
                                                                        + Constant.RIGHT_SMALL_BRACKET
                                                                        + Constant.LEFT_SMALL_BRACKET
                                                                        + Constant.PRODUCT_CODE_REGEX_STR
                                                                        + Constant.XINGHAO_REGEX_STR
                                                                        + Constant.ORDERNUM_REGEX_STR
                                                                        + Constant.XINGHAO_REGEX_STR
                                                                        + Constant.ORDERNUM_REGEX_STR
                                                                        + Constant.XINGHAO_REGEX_STR
                                                                        + Constant.MONEY_REGEX_STR
                                                                        + Constant.JINGHAO_REGEX_STR
                                                                        + Constant.RIGHT_SMALL_BRACKET
                                                                        + Constant.REGEX_PLUS_STR
                                                                        + Constant.REGEX_END_STR;
    public static final String  SEND_STK_MIN_STORAGE_SMS_REGEX_STR      =
                                                                        Constant.REGEX_START_STR
                                                                        + Constant.LEFT_SMALL_BRACKET
                                                                        + Constant.SENDSTK_STORAGE_SMS_SERVICE_CODE
                                                                        + Constant.XINGHAO_REGEX_STR
                                                                        + Constant.COUNTER_REGEX_STR
                                                                        + Constant.XINGHAO_REGEX_STR
                                                                        + Constant.TERMINALID_REGEX_STR
                                                                        + Constant.XINGHAO_REGEX_STR
                                                                        + Constant.PRODUCT_CODE_REGEX_STR
                                                                        + Constant.XINGHAO_REGEX_STR
                                                                        + Constant.ORDERNUM_REGEX_STR
                                                                        + Constant.JINGHAO_REGEX_STR
                                                                        + Constant.RIGHT_SMALL_BRACKET
                                                                        + Constant.REGEX_END_STR;

    public static final String  SMS_RECORD_SPLIT                        = "#";
    public static final String  SMS_FIELD_SPLIT                         = "\\*";

    public static final String  BUSINESSWORKER_DEDUCT_RULE_PLACE_HOLDER = "###";
    public static final String  BUSINESSWORKER_DEDUCT_RULE_SAPARATOR    = ",";

    public static final String  NO_VALUE                                = "无";

    public static final Long    ADMIN_USER_ROLE_ID                      = 1L;

    public static final String  PROJECT_CODE                            = "JML";

    public static final String  EXIST                                   = "1";
    public static final String  NOT_EXIST                               = "0";

    public static final String  SEPARATOR_COMMA                         = ",";
    public static final String  SEPARATOR_DIVIDE                        = "/";
    
    public static final String  STATUS_UPLOAD_WAIT                      = "100";                                                     // 依赖基础数据不完整
    public static final String  STATUS_UPLOAD_OVER                      = "101";                                                     // CRC校验中上传成功
    public static final String  STATUS_DEAL_OVER                        = "102";                                                     // CRC校验中上处理完成
    public static final String  STATUS_DEAL_ERROR                       = "103";                                                     // CRC校验中的处理失败

}
