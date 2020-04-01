package com.hou.mybatisplus.user.entity;

public class Constants {

	//public static final String API_PDM_BASE_URL="http://127.0.0.1:8080/pdm";
	//public static final String API_PDM_BASE_URL="http://10.104.56.110:1800/pdm"; //正式内网环境
	//public static final String API_PDM_BASE_URL="http://10.104.59.17:16100/pdm"; //测试内网环境
	public static final String API_PDM_BASE_URL="http://c2.zhuzher.com/pdm"; //
	public static final String API_METHOD_QUERYHOTELINFOBYHOTELID="/hotel/queryHotelInfoByHotelid";//根据hotelid查询当前酒店信息
	public static final String API_METHOD_QUERYGROUPHOTELLISTBYHOTELID="/hotel/queryGroupHotelListByHotelid";//根据hotelid查询当前酒店所属集团下的所有酒店列表
	public static final String API_METHOD_QUERYPMSHOTELLISTBYCHAINID="/hotel/queryPMSHotelListByChainid";//根据集团编号chainid查询集团下所有酒店列表

	public static final String LY_LABRADOR_TOKEN = "77974ff0-c645-41dd-a418-70d7a16166f1";//同程艺龙请求头固定参数
	public static final String LY_GETACCESSTOKEN="http://servicegw.ly.com/gateway/oa.message.api/v1/oauth/getaccesstoken/";//同程艺龙权限认证接口--获取accesstoken
	public static final String JWT_WEB_SECRET = "425809088f646c56a3412174f5e188b0";

	public static final String TOKEN_ISSUER = "ZHUZHER_JWT_AUTHER";

	public static final Long TOKEN_EXPIRED_TIME = 2 * 60 * 60l; //token 2个小时的有效时间
	//public static final Long TOKEN_EXPIRED_TIME = 2 * 60l; //token 2分钟的有效时间
	//public static final Long TOKEN_EXPIRED_TIME = 10l; //token 2个小时的有效时间

	public static final Long TOKEN_REFRESH_TIME = 24 * 60 * 60l; //refresh token 1天的有效刷新时间
    public static final String AUTHORIZATION = "Authorization";
    //public static final Long TOKEN_REFRESH_TIME =  5 * 60l; //refresh token 5分钟

	public static String UPLOAD_URL = "http://weixin.zhuzher.com/imgcdn/upload/";
	public static String UPLOAD_GROUP = "cdm_ewechat_qrcode";

	public static final String LY_GETWECHATCODE="https://moa.17u.cn/message/common/getWeChatCode";//获取企业微信code，用于身份认证
	public static final String LY_GETUSERINFOBYCODE="http://servicegw.ly.com/gateway/oa.message.api/v1/wechat/getuserinfobycode/";//企业微信回调code换算人员信息
	public static final String TEMP_SAVE_EWECHATUSERINFOQRCODE ="/tdata/home/tcrm/ewechatuserinfoqrcode/";//临时存放关联企业微信二维码路径
	public static final String LY_GETCODEREDIRECTURL="http://c2.zhuzher.com?user_id=1001";//回调地址，需要修改成正式的H5地址

	public static final String LY_SENDTEXTMESSAGE= "http://servicegw.ly.com/gateway/oa.message.api/v1/message/sendtext/";//企业微信发送--文本消息
	public static final String LY_SENDTEXTCARDMESSAGE= "http://servicegw.ly.com/gateway/oa.message.api/v1/message/sendtextcard/";//企业微信发送--卡片消息

	public static final String SKIP_URL_APPROVAL_ORDER="http://www.baidu.com";//进入审批单移动审批页面
	public static final String SKIP_URL_ORDER="http://www.baidu.com";//进入订单移动审批页面
}
