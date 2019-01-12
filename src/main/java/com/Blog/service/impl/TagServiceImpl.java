package com.Blog.service.impl;

/*
 * 作者：赵国应
 * 时间：2019-1-12
 * 描述：标签业务实现
 */

import com.Blog.mapper.TagMapper;
import com.Blog.model.Tag;
import com.Blog.service.TagService;
import net.sf.json.JSONArray;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagMapper tagMapper;

    @Override
    public void addTags(String[] tags, int tagSize) {
        for (String tag : tags){
            if(tagMapper.findIsExitByTagName(tag) == 0){
                Tag t = new Tag(tag,tagSize);
                tagMapper.insertTag(t);
            }
        }
    }

    @Override
    public JSONObject findTagsCloud() {
        List<Tag> tags = tagMapper.findTagsCloud();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status",200);
        jsonObject.put("result", JSONArray.fromObject(tags));
        //jsonObject.put("result",tags);
        jsonObject.put("tagsNum",tags.size());
        return jsonObject;
    }

    @Override
    public int countTagsNum() {
        return tagMapper.countTagsNum();
    }

    @Override
    public int getTagsSizeByTagName(String tagName) {
        return tagMapper.getTagsSizeByTagName(tagName);
    }
}

