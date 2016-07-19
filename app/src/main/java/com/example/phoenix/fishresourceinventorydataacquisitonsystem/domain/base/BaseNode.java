package com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base;

/**
 * Created by Phoenix on 2016/6/23.
 */
public abstract class BaseNode {
    /**
     * 获取节点在表结构中的主键
     *
     * @return
     */
    public abstract String getKey();

    /**
     * 获取节点在树形结构中的层级
     *
     * @return
     */
    public abstract int getLevel();
}
