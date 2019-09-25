package com.yudu.file_convert.utils;

import com.yudu.file_convert.VO.ResultVO;
import com.yudu.file_convert.enums.ResultVOEnum;

public class ResultVOUtil {
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ResultVOEnum.CONVERT_SUCCESS.getCode());
        resultVO.setMsg(ResultVOEnum.CONVERT_SUCCESS.getMsg());
        resultVO.setData(object);
        return resultVO;
    }

    public  static ResultVO error(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ResultVOEnum.CONVERT_ERROR.getCode());
        resultVO.setMsg(ResultVOEnum.CONVERT_ERROR.getMsg());
        resultVO.setData(object);
        return resultVO;
    }
    public static ResultVO fileNotEmpty(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ResultVOEnum.FILE_NOT_EMPTY.getCode());
        resultVO.setMsg(ResultVOEnum.FILE_NOT_EMPTY.getMsg());
        resultVO.setData(object);
        return resultVO;
    }
    //没有数据
    public static ResultVO success(){
        return success(null);
    }
}
