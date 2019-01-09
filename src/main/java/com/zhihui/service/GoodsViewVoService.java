package com.zhihui.service;

import com.github.pagehelper.Page;
import com.tools.vo.PageBeanVo;
import com.zhihui.vo.GoodsViewVo;

import java.util.List;

public interface GoodsViewVoService {

    PageBeanVo<GoodsViewVo> findgoodsView(Integer gtid, int page, int limit);

}
