 /************商品相册****************/
//初始化Web Uploader
 var uploader = WebUploader.create({
     // 选完文件后，是否自动上传。
     auto: true,
     // swf文件路径
     swf: 'Uploader.swf',
     // 文件接收服务端。
     server: '/goods/upload',
     fileNumLimit :5,
     // 选择文件的按钮。可选。
     // 内部根据当前运行是创建，可能是input元素，也可能是flash.
     pick: '#filePicker',
     // 只允许选择图片文件。
     accept: {
         title: 'Images',
         extensions: 'gif,jpg,jpeg,bmp,png',
         mimeTypes: 'image/*'
     }
 });

 $list = $("#fileList");
 var thumbnailWidth = 100;
 var thumbnailHeight = 100;
//当有文件添加进来的时候
 uploader.on( 'fileQueued', function( file ) {
     var $li = $(
             '<div id="' + file.id + '"  class="file-item">' +
                 '<img>'+
                 //'<div class="info">' + file.name + '</div>' +
                 '<div class="diyCancel">'+'</div>'+
           '</div>'
             ),
         $img = $li.find('img');
     // $list为容器jQuery实例
     $list.append( $li );
     // 创建缩略图
     // 如果为非图片文件，可以不用调用此方法。
     // thumbnailWidth x thumbnailHeight 为 100 x 100
     uploader.makeThumb( file, function( error, src ) {
         if ( error ) {
             $img.replaceWith('<span>不能预览</span>');
             return;
         }
         $img.attr( 'src', src ); 
     }, thumbnailWidth, thumbnailHeight );
 });
 
//文件上传过程中创建进度条实时显示。
 uploader.on( 'uploadProgress', function( file, percentage ) {
     var $li = $( '#'+file.id ),
         $percent = $li.find('.progress span');

     // 避免重复创建
     if ( !$percent.length ) {
         $percent = $('<p class="progress"><span></span></p>')
                 .appendTo( $li )
                 .find('span');
     }

     $percent.css( 'width', percentage * 100 + '%' );
 });

 // 文件上传成功，给item添加成功class, 用样式标记上传成功。
 uploader.on( 'uploadSuccess', function( file,response) {
	 
	 var size = $(".file-item").size()-1;
	 var li = $( '#'+file.id );
	if (response.success) {
		li.append("<input type='hidden'  name='originalImg' value='"+response.goodsImgArr+"' />");
		li.append("<input type='hidden'  name='smallThumbImg' value='"+response.originalImgArr+"' />");
	    li.append("<input type='hidden'  name='bigThumbImg' value='"+response.originalImgArr+"' />");
	    li.addClass('upload-state-done');
	}else{
		li.append("<p>上传失败</p>");
	}
 });

 // 文件上传失败，显示上传出错。
 uploader.on('uploadError', function( file ) {
     var $li = $( '#'+file.id ),
         $error = $li.find('div.error');

     // 避免重复创建
     if ( !$error.length ) {
         $error = $('<div class="error"></div>').appendTo( $li );
     }

     $error.text('上传失败');
 });

// 完成上传完了，成功或者失败，先删除进度条。
uploader.on( 'uploadComplete', function( file ) {
    $( '#'+file.id ).find('.progress').remove();
});
//商品上传图片点击删除
$(document).ready(function(){

	
	$("body").on('mouseover',".file-item", function() {
		$(this).addClass("hover");
 })

$("body").on('mouseout',".file-item", function() {
		 $(this).removeClass("hover");
 })
 })
 
// 需要删除的相册id
var delThumb = "";

 //商品上传图片点击删除
  $(document).ready(function(){
	  $("body").on('click',".diyCancel", function() {
		var imgDiv = $(this).parent();
		var imgId = imgDiv.find("[ name=\"imgIdArr\" ]").val();
		var fileId = $(imgDiv).attr("id");
		if (typeof(imgId) != "undefined") {
			if (delThumb == "") {
				delThumb = imgId;
			} else {
				delThumb = delThumb + "," +imgId;
			}
			
			$("#delThumbId").val(delThumb);
		}
		
	
	
		// 如果删除的是主图
		if ($(this).parent().parent().attr("id") == 'mainfile') {
			
			if(fileId){
				mainUploader.removeFile( fileId,true );
			}
			var mainDiv = $('#mainfile');
			mainDiv.find("[ name = 'goodsMainImg' ]").attr("value", null);
//			mainDiv.find("[ name = 'goodsThumb' ]").attr("value", null);
//			mainDiv.find("[ name = 'originalImg' ]").attr("value", null);
		}else{
			if(fileId){
				uploader.removeFile( fileId,true );
			}
		}
		
		$(this).parent().remove();
	  })
  });
 
 /************商品主图****************/
//初始化Web Uploader
 var mainUploader = WebUploader.create({
     // 选完文件后，是否自动上传。
     auto: true,
     // swf文件路径
     swf: 'Uploader.swf',
     // 文件接收服务端。
     server: '/goods/upload',
     fileNumLimit :1,
     // 选择文件的按钮。可选。
     // 内部根据当前运行是创建，可能是input元素，也可能是flash.
     pick: '#mainPicker',
     // 只允许选择图片文件。
     accept: {
         title: 'Images',
         extensions: 'gif,jpg,jpeg,bmp,png',
         mimeTypes: 'image/*'
     }
 });

 $mainFile = $("#mainfile");
//当有文件添加进来的时候
mainUploader.on( 'fileQueued', function( file ) {
	$("#mainfile .file-item").remove();
    var $li = $(
            '<div id="' + file.id + '"  class="file-item">' +
                '<img>'+
                //'<div class="info">' + file.name + '</div>' +
                '<div class="diyCancel">'+'</div>'+
          '</div>'
            ),
        $img = $li.find('img');
    // $list为容器jQuery实例
    $mainFile.append( $li );
    // 创建缩略图
    // 如果为非图片文件，可以不用调用此方法。
    // thumbnailWidth x thumbnailHeight 为 100 x 100
    mainUploader.makeThumb( file, function( error, src ) {
        if ( error ) {
            $img.replaceWith('<span>不能预览</span>');
            return;
        }
        $img.attr( 'src', src ); 
    }, thumbnailWidth, thumbnailHeight );
});
// 文件上传成功，给item添加成功class, 用样式标记上传成功。
mainUploader.on( 'uploadSuccess', function(file, response) {
	 var size = $(".file-item").size()-1;
	 var li = $( '#'+file.id );
	 var mainDiv = $('#mainfile');
	if (response.success) {
		mainDiv.find("[ name = 'goodsMainImg' ]").attr("value", response.goodsImgArr);
//		mainDiv.find("[ name = 'goodsOriginalImg' ]").attr("value", response.originalImgArr);
//		mainDiv.find("[ name = 'goodsThumbimg' ]").attr("value", response.thumbimg);
	    li.addClass('upload-state-done');
	} else {
		li.append("<p>上传失败</p>");
	}
});