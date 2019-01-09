package com.zhihui.service;

import com.zhihui.vo.GoodsViewVo;

import java.util.List;

public interface GoodsViewVoService {

    List<GoodsViewVo> findgoodsView(Integer gtid);

}
