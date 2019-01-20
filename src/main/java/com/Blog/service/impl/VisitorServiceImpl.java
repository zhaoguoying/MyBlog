package com.Blog.service.impl;

/*
 * 作者：赵国应
 * 时间：2019-1-13
 * 描述：访客实现
 */

import com.Blog.mapper.VisitorMapper;
import com.Blog.service.VisitorService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    VisitorMapper visitorMapper;

    @Override
    public void addVisitorNumByPageName(String pageName, HttpServletRequest request) {
        String visitor;
        if ("visitorVolum".equals(pageName)) {
            visitor = (String) request.getSession().getAttribute("visitor");
            if (visitor == null) {
                visitorMapper.updateVisitorNumByTotalVisitorAndPageName(pageName);
                request.getSession().setAttribute("visitor", "yes");
            } else {
                visitorMapper.updateVisitorNumByTotalVisitor();
            }
        } else {
            visitor = (String) request.getSession().getAttribute(pageName);
            if (visitor == null) {
                visitorMapper.updateVisitorNumByTotalVisitorAndPageName(pageName);
                request.getSession().setAttribute(pageName, "yes");
            } else {
                visitorMapper.updateVisitorNumByTotalVisitor();
            }
        }
    }

    @Override
    public JSONObject getVisitorNumByPageName(String pageName) {
        long totalVisitor = visitorMapper.getVisitorNumByPageName("totalVisitor");
        long pageVisitor = visitorMapper.getVisitorNumByPageName(pageName);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("totalVisitor",totalVisitor);
        jsonObject.put("pageVisitor",pageVisitor);
        return jsonObject;
    }

    @Override
    public long getNumByPageName(String pageName) {
        return visitorMapper.getVisitorNumByPageName(pageName);
    }

    @Override
    public void insertVisitorArticlePage(String pageName) {
        visitorMapper.insertVisitorArticlePage(pageName);
    }

    @Override
    public long getAllVisitor() {
        return visitorMapper.getAllVisitor();
    }

}
