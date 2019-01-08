package com.zhihui.service.impl;

import com.zhihui.dao.ReceivingDetailMapper;
import com.zhihui.dao.ReplyMapper;
import com.zhihui.entity.ReceivingDetail;
import com.zhihui.service.ReceivingService;
import com.zhihui.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceivingServiceImpl implements ReceivingService {
    @Autowired
    private ReceivingDetailMapper receivingDao;
    @Override
    public ResultVo findOneRec(Integer uid) {
        ReceivingDetail oneRec = receivingDao.findOneRec(uid);
        return ResultVo.setOK(oneRec) ;
    }
}
