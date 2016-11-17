var Upload = {
		/**
		 * 
		 * @param picker 选择器
		 * @param container 文件上传容器
		 * @param input 对应的输入框
		 * @param num 添加图片数量
		 * @param replace 是否替换以前的图片
		 * @returns
		 */
	init:function(picker,container,input,replace,num){
		if(!num){
			num=1;
		}
		var uploader = {
				
		};
		//初始化Web Uploader
		uploader.mainUploader = WebUploader.create({
		     // 选完文件后，是否自动上传。
		     auto: true,
		     // swf文件路径
		     swf: '/webuploader/Uploader.swf',
		     // 文件接收服务端。
		     server: '/image/upload',
		     fileNumLimit :num,
		     // 选择文件的按钮。可选。
		     // 内部根据当前运行是创建，可能是input元素，也可能是flash.
		     pick: picker,
		     // 只允许选择图片文件。
		     accept: {
		         title: 'Images',
		         extensions: 'gif,jpg,jpeg,bmp,png',
		         mimeTypes: 'image/*'
		     }
		 });
		 
		uploader.mainFile = $(container);
		 
		 
		//当有文件添加进来的时候
		uploader.mainUploader.on( 'fileQueued', function( file ) {
			
			if(replace){
				$(".file-item").remove();
			}
		     var $li = $(
		             '<div id="' + file.id + '"  class="file-item">' +
		                 '<img>'+
		                 //'<div class="info">' + file.name + '</div>' +
		                 '<div class="diyCancel">'+'</div>'+
		           '</div>'
		             ),
		      $img = $li.find('img');
		     // $list为容器jQuery实例
		     uploader.mainFile.append( $li );
		     // 创建缩略图
		     // 如果为非图片文件，可以不用调用此方法。
		     // thumbnailWidth x thumbnailHeight 为 100 x 100
		     uploader.mainUploader.makeThumb( file, function( error, src ) {
		         if ( error ) {
		             $img.replaceWith('<span>不能预览</span>');
		             return;
		         }
		         $img.attr( 'src', src ); 
		     }, 100, 100 );
		 });
		 
		 // 文件上传成功，给item添加成功class, 用样式标记上传成功。
		uploader.mainUploader.on( 'uploadSuccess', function(file, response) {
			console.log(response.file);
		      var li = $( '#'+file.id );
		      var mainDiv = $(container);
		     if (response.success) {
		    	 console.log("[ name = '"+input+"' ]");
		    	 
		         mainDiv.find("[ name = '"+input+"' ]").attr("value", response.file);
		         li.addClass('upload-state-done');
		     } else {
		         li.append("<p>上传失败</p>");
		     }
		 });
		
		uploader.mainUploader.on( 'uploadError', function( file ) {
		    $( '#'+file.id ).find('p.state').text('上传出错');
		});

		uploader.mainUploader.on( 'uploadComplete', function( file ) {
		    $( '#'+file.id ).find('.progress').fadeOut();
		});
		
		return uploader;
	}	
}




 
