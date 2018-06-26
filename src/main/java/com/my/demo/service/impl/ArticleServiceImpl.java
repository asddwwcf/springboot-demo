package com.my.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.my.demo.dao.ArticleDao;
import com.my.demo.service.ArticleService;
import com.my.demo.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    /**
     * 新增文章
     *
     * @param jsonObject
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject addArticle(JSONObject jsonObject) {
        articleDao.addArticle(jsonObject);
        return CommonUtil.successJson();
    }

    /**
     * 文章列表
     *
     * @param jsonObject
     * @return
     */
    @Override
    public JSONObject listArticle(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = articleDao.countArticle(jsonObject);
        List<JSONObject> list = articleDao.listArticle(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    /**
     * 更新文章
     *
     * @param jsonObject
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject updateArticle(JSONObject jsonObject) {
        articleDao.updateArticle(jsonObject);
        return CommonUtil.successJson();
    }
}
