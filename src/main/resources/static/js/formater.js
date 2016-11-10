/**
 * 格式化long型日期
 * @param datetime 日期的long型
 * @param formate 格式
 */
function dateFormat(datetime,formate){
	if(datetime){
		return new Date(datetime).format(formate);
	}else{
		return '';
	}
}
