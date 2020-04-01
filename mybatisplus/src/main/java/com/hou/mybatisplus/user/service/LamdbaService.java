package com.hou.mybatisplus.user.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.hou.mybatisplus.user.entity.ErrorCode;
import com.hou.mybatisplus.user.entity.ResMsg;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 默认lamdba接口
 */
public interface LamdbaService {

    //无参数有返回值
    default ResMsg respsMsgWhileSupplier(Supplier supplier){
        return ResMsg.success(supplier.get());
    }

    /**
     * 接收两个参数，返回function.apply的Boolean值
     * @param o1
     * @param o2
     * @param function
     * @return
     */
    default <T> ResMsg respsMsgWhileFunction(T o1, T o2, BiFunction<T, T, Boolean> function){
        return respsMsgByBoolean(function.apply(o1, o2));
    }

    /**
     * 接收一个object， 返回function.apply的Boolean值
     * @param object
     * @param function
     * @return
     */
    default <T> ResMsg respsMsgWhileFunction(T object, Function<T, Boolean> function){
        return respsMsgByBoolean(function.apply(object));
    }

    /**
     * true时返回成功，false时返回失败
     * @param bol
     * @return
     */
    default ResMsg respsMsgByBoolean(Boolean bol){
        return respsMsgByBoolean(bol, ErrorCode.FAIL);
    }

    /**
     * true时返回成功，false时返回指定errorcode
     * @param bol
     * @param errorCode
     * @return
     */
    default ResMsg respsMsgByBoolean(Boolean bol, ErrorCode errorCode){
        if(bol)
            return respsMsgWithErrorCode(ErrorCode.SUCCESS);
        return respsMsgWithErrorCode(errorCode);
    }

    /**
     * 返回指定Errorcode信息
     * @param errorCode
     * @return
     */
    default ResMsg respsMsgWithErrorCode(ErrorCode errorCode){
        return ResMsg.failture(errorCode);
    }

    /**
     * 返回指定code错误信息
     * @param code
     * @return
     */
    default ResMsg respsMsgWithErrorCode(Integer code){
        return respsMsgWithErrorCode(ErrorCode.map.get(code));
    }

    /**
     * 接收一个参数，携带function.apply的信息，返回成功。
     * @param o1
     * @param function
     * @return
     */
    default <T> ResMsg repsSuccessMsg(T o1, Function<T, Object> function){
        return repsSuccessMsg(function.apply(o1));
    }

    /**
     * 接收两个参数，携带function.apply的信息，返回成功。
     * @param o1
     * @param o2
     * @param function
     * @return
     */
    default <T> ResMsg repsSuccessMsg(T o1, T o2, BiFunction<T, T, Object> function){
        return repsSuccessMsg(function.apply(o1, o2));
    }

    /**
     * 携带指定object的信息，返回成功。
     * @param o1
     * @return
     */
    default ResMsg repsSuccessMsg(Object o1){
        return ResMsg.success(o1);
    }

    /**
     * 接收1个参数，如果数据处理的结果不满足校验器的校验，返回errorcode。否则携带function.apply，返回成功
     * @param o1 function入参
     * @param function 数据处理器
     * @param predicate 结果校验器
     * @param errorCode predicate校验失败的时候，返回的错误码
     * @param <T>
     * @return
     */
    default <T> ResMsg repsFailMsg(R o1, Function<R, T> function, Predicate<T> predicate, ErrorCode errorCode){
        T t = function.apply(o1);
        if(!predicate.test(t))
            return respsMsgWithErrorCode(errorCode);
        return repsSuccessMsg(t);
    }
}
