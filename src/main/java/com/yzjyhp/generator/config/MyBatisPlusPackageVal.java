/** Copyright © 2026, QiZhiDao Network Co.,Ltd. All rights reserved.
 * QiZhiDao PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.yzjyhp.generator.config;

/**
 * Description: MyBatisPlus 2.X版本地址
 * Date: 2026/4/8 13:31
 * @author: yzjyhp
 * @version 1.0.0
 */
public class MyBatisPlusPackageVal {

    public static boolean v3 = false;

    public static void setV3(boolean v3) {
        MyBatisPlusPackageVal.v3 = v3;
    }

    public static String BaseMapper() {
        if (v3) {
            return MyBatisPlusPackageValV3.BaseMapper;
        } else {
            return MyBatisPlusPackageValV2.BaseMapper;
        }
    }

    public static String IService() {
        if (v3) {
            return MyBatisPlusPackageValV3.IService;
        } else {
            return MyBatisPlusPackageValV2.IService;
        }
    }

    public static String ServiceImpl() {
        if (v3) {
            return MyBatisPlusPackageValV3.ServiceImpl;
        } else {
            return MyBatisPlusPackageValV2.ServiceImpl;
        }
    }

    public static String Model() {
        if (v3) {
            return MyBatisPlusPackageValV3.Model;
        } else {
            return MyBatisPlusPackageValV2.Model;
        }
    }

    public static String TableName() {
        if (v3) {
            return MyBatisPlusPackageValV3.TableName;
        } else {
            return MyBatisPlusPackageValV2.TableName;
        }
    }

    public static String TableLogic() {
        if (v3) {
            return MyBatisPlusPackageValV3.TableLogic;
        } else {
            return MyBatisPlusPackageValV2.TableLogic;
        }
    }

    public static String Version() {
        if (v3) {
            return MyBatisPlusPackageValV3.Version;
        } else {
            return MyBatisPlusPackageValV2.Version;
        }
    }

    public static String TableField() {
        if (v3) {
            return MyBatisPlusPackageValV3.TableField;
        } else {
            return MyBatisPlusPackageValV2.TableField;
        }
    }

    public static String TableId() {
        if (v3) {
            return MyBatisPlusPackageValV3.TableId;
        } else {
            return MyBatisPlusPackageValV2.TableId;
        }
    }

    public static String IdType() {
        if (v3) {
            return MyBatisPlusPackageValV3.IdType;
        } else {
            return MyBatisPlusPackageValV2.IdType;
        }
    }

    public static String FieldFill() {
        if (v3) {
            return MyBatisPlusPackageValV3.FieldFill;
        } else {
            return MyBatisPlusPackageValV2.FieldFill;
        }
    }

    public static String Page() {
        if (v3) {
            return MyBatisPlusPackageValV3.Page;
        } else {
            return MyBatisPlusPackageValV2.Page;
        }
    }

    public static String Param() {
        if (v3) {
            return MyBatisPlusPackageValV3.Param;
        } else {
            return MyBatisPlusPackageValV2.Param;
        }
    }
}
