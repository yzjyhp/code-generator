/** Copyright © 2026, QiZhiDao Network Co.,Ltd. All rights reserved.
 * QiZhiDao PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.yzjyhp.generator.config.po;

/**
 * Description:
 * Date: 2026/4/7 20:28
 * @author: yzjyhp
 * @version 1.0.0
 */

/**
 * <p>
 * 字段填充策略枚举类
 * </p>
 *
 * @author hubin
 * @Date 2017-06-27
 */
public enum FieldFill {
    DEFAULT(0, "默认不处理"),
    INSERT(1, "插入填充字段"),
    UPDATE(2, "更新填充字段"),
    INSERT_UPDATE(3, "插入和更新填充字段");

    /**
     * 主键
     */
    private final int key;

    /**
     * 描述
     */
    private final String desc;

    FieldFill(final int key, final String desc) {
        this.key = key;
        this.desc = desc;
    }

    public static FieldFill getIgnore(int key) {
        FieldFill[] fis = FieldFill.values();
        for (FieldFill fi : fis) {
            if (fi.getKey() == key) {
                return fi;
            }
        }
        return FieldFill.DEFAULT;
    }

    public int getKey() {
        return this.key;
    }

    public String getDesc() {
        return this.desc;
    }

}

