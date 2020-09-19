package com.dubbo.api.po;

public enum ContentConfig {
    /**infoType 消息类型（0-待回复；1-用户审批;2-互助圈审批;3-创建学校审批）**/
    INFOTYPE_ANSWER(0),
    INFOTYPE_USER_APPROVE(1),
    INFOTYPE_HELPCIRCLE_APPROVE(2),
    INFOTYPE_CREATESCHOOL_APPROVE(3);
    private final int value;

    ContentConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
        System.out.println(ContentConfig.INFOTYPE_ANSWER.getValue());
    }
}
