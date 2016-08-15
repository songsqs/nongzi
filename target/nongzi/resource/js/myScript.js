/*
 * 一些公共脚本函数
 */


var EMPTY_ARRAY = new Array();



function getValueAsArray(obj, field) {
    var value = getValue(obj, field);
    if (value == null) {
        return EMPTY_ARRAY;
    }
    return value;
}

function getValue(obj, field) {
    if (obj == null || field == null) {
        return null;
    }
    var value = obj[field];
    return value;
}





/**
 * 查找并返回指定id的元素。如果没有找到则弹出相应的提示。
 * @param {} id 元素的id
 * @returns {} 查找到的元素
 */
function getElementById(id) {
    var element = document.getElementById(id);
    if (element == null) {
        alert("找不到元素:id=" + id);
    }
    return element;
}


/**
 * 检测指定id的控件的value是否合法。如果value为空，或value长度超过maxCount，则给出相弹出msg提示。
 * @param {} id 控件id
 * @param {} valuename 此项输入的名称
 * @param {} maxCount 此项的最大长度
 * @returns {} 如果合法(value不为空，且长度不超过maxCount)，则返回该控件。
 *              否则返回null。如果是输入上的问题，则还会focus到该控件。
 */
function checkElement(id, valuename, maxCount) {
    var element = getElementById(id);
    if (element == null) {
        return null;
    }
    var value = element.value;
    var msg = null;
    if (value == "") {
        msg = "请输入" + valuename;
    } else if (value.length > maxCount) {
        msg = valuename + "长度不能超过" + maxCount;
    }
    
    if (msg != null) {
        alert(msg);
        element.focus();
        return null;
    }

    return element;
}



function checkLengthAndSet(toInputId, fromId, valuename, maxCount) {
	var element = getElementById(fromId);
    if (element == null) {
        return false;
    }
    
    var value = element.value;
    var msg = null;
    if (value.length > maxCount) {
        msg = valuename + "长度不能超过" + maxCount;
    }
    
    if (msg != null) {
        alert(msg);
        element.focus();
        return false;
    }
    
    var toElement = getElementById(toInputId);
    if (toElement == null) {
    	return false;
    }
    
    toElement.value = value;

    return true;
}


function checkAndGetSelectValue(id, valuename, defaultValue) {
    var element = getElementById(id);
    if (element == null) {
        return null;
    }
    
    if (defaultValue == null || defaultValue == undefined) {
        defaultValue = '0';
    }
    var value = element.value;
    var msg = null;
    if (value == "" || value == defaultValue) {
        msg = valuename;
    }
    
    if (msg != null) {
        alert(msg);
        element.focus();
        return null;
    }
    
    return value;
}


function checkAndGetValue(id, valuename, maxCount) {
    var element = checkElement(id, valuename, maxCount);
    if (element == null) {
        return null;
    }
    
    var value = element.value;
    
    return value;
}



/**
 * 检测指定fromId的value是否为空，并把其值赋值给指定的input
 * @param {} toInputId input控件的id
 * @param {} fromId 把这个控件的value赋值给toInputId
 * @param {} valuename 此项输入的名称
 * @param {} maxCount 此项的最大长度
 * @returns {} 如果合法(value不为空，且长度不超过maxCount)，返回true。不合法返回false。
 */
function checkAndSetInput(toInputId, fromId, valuename, maxCount) {
    var from = checkElement(fromId, valuename, maxCount);
    if (from == null) {
        return false;
    }
    
    var input = getElementById(toInputId);
    if (input == null) {
        return false;
    }

    input.value = from.value;
    return true;
}


/**
 * 检测选择控件是否已正确选择，并把选择的值赋值给指定的input
 * @param defaultValue 未选择时的默认值
 * @returns {Boolean} 是否成功
 */
function checkAndSetSelectInput(inputId, selectId, valuename, defaultValue) {
    var value = checkAndGetSelectValue(selectId, valuename, defaultValue);
    if (value == null) {
        return false;
    }
    
    $('#' + inputId).val(value);
    return true;
}




function checkAndSetPhotoIdInput(photoIdInputId, frameId, usePhotoId, valuename) {
    var frame = getElementById(frameId);
    if (frame == null) {
        return false;
    }
    var photoId = findPhotoId(frame);
    if (photoId > 0) {
        var photoIdInput = getElementById(photoIdInputId);
        if (photoIdInput == null) {
            return false;
        }
        photoIdInput.value = photoId;
    } else if (usePhotoId) {
        alert('请上传' + valuename);
        return false;
    }
    return true;
}





function uploaderInputChange(uploaderInputId, uploarderFormId, uploarderImgId) {
    if(!checkImageFile(uploaderInputId)) {
        return false;
    }
    $('#' + uploarderFormId).submit();
    
    var input = getElementById(uploaderInputId);
    if (input == null) {
        return false;
    }
    var hasFile = input.files.length;
    return hasFile;
}


function checkImageFile(inputId) {
    try {
        var maxsize = 5*1024*1024;
        var obj_file = document.getElementById(inputId);
        var filesize = obj_file.files[0].size;
        if(filesize >= maxsize) {
            alert("图片大小不能超过5M!");
            return false;
        }
    }catch(e){
    }
    return true;
}


function setPreview(inputId, imgId) {
    var input = getElementById(inputId);
    if (input == null) {
        return false;
    }

    var img = getElementById(imgId);
    if (img == null) {
        return false;
    }

    if (input.files.length >= 1) {
        img.src = window.URL.createObjectURL(input.files[0]);
        return true;
    }
    return false;
}



function findPhotoId(frame) {
    if (frame == null) {
        return 0;
    }
    var content = frame.contentWindow.document.body.innerHTML;
    var idIndex = content.indexOf('"photoId":');
    if(idIndex > 0) {
        var temp = content.substr(idIndex + 10);
        var tempIndex = temp.indexOf("}");
        var photoId = temp.substr(0,tempIndex);
        return photoId;
    } else {
        return 0;
    }
}




/**
 * 点击某个tab时
 * @param {} queryType 此tab的请求类型
 * @param {} queryTypeG 此页面当前的请求类型
 * @param {} queryTypeInputId queryType的input控件的id
 * @returns {}
 *     true 如果没有问题，可以发请求
 *     false 如果出问题，或者两个请求类型一致
 */
function clickTab(queryType, queryTypeG, queryTypeInputId){
    if (queryType === queryTypeG){
        return false;
    }
    var queryTypeInput = getElementById(queryTypeInputId);
    if (queryTypeInput == null) {
        return false;
    }
    queryTypeInput.value = queryType;
    return true;
}










// -------------------------------------------------------------------------
// -------------------------------------------------------------------------
// -------------------------------------------------------------------------
// 
// ImageUploaderMaker
// author: wencheng.song


/**
 * 用于生成上传图片的html代码
 * 
 * @用法：
 * <script> 
 * var maker = new ImageUploaderMaker(//
 *      'maker',
 *      '${ctx}',
 *      '项目封面',
 *      '${ctx}/upload',
 *      '${uploaderId}',
 *      'projectIconContainer',
 *      ${maxCount} );
 * </script>
 * 
 * <div id='projectIconContainer' ></div>
 * 
 * <button onclick="maker.clickAdd()">添加</button>
 * <button onclick="maker.getPhotoUrlJSONArray()">提交</button>
 * 
 * author: wencheng.song 
 */
function ImageUploaderMaker(myId, ctx, key, action, uploaderId, containerId, maxCount, showDelete) {

    // -----------------------------
    // 定义实例变量
    
    /**
     * 自己的id
     */
    this.myId = myId;
    
    /**
     * web容器路径 
     */
    this.ctx = ctx;
    
    /**
     * 此maker的关键字
     */
    this.key = key;
    
     /**
     * 上传接口的路径 
     */
    this.action = action;
    
    /**
     * 上传者的id 
     */
    this.uploaderId = uploaderId;
    
    /**
     * uploader容器的id
     */
    this.containerId = containerId;
    
    /**
     * 最大张数
     */
    this.maxCount = maxCount;
    
    this.showDelete = showDelete == null ? true : showDelete;
    
    /**
     * 当前最大的index，用于确定下一个要添加的元素的index，每增加一个元素，此值应该+1
     */
    this.currentMaxIndex = 0;
    
    /**
     * 存放数据的数组.每个元素:{key:'', orgPhotoUrl:'', status: 1}
     */
    this.itemArray = new Array();
    
    // 定义实例变量
    // -----------------------------
}

// -----------------------------
// 定义常量

/**
 * 没有此frame，说明此frame可能被删除过
 */
ImageUploaderMaker.prototype.NO_FRAME = -1;
    
/**
 * 没有上传图片
 */
ImageUploaderMaker.prototype.NOT_UPLOAD = -2;
    
/**
 * 上传图片出错 
 */
ImageUploaderMaker.prototype.UPLOAD_ERROR = -3;


ImageUploaderMaker.prototype.INIT = -5;

ImageUploaderMaker.prototype.UPLOADING = -6;

ImageUploaderMaker.prototype.UPLOAD_SUCCESS = -7;



    
// 定义常量
// -----------------------------



ImageUploaderMaker.prototype.clickAdd = function() {
    if (this.itemArray.length >= this.maxCount) {
        alert('已达到最大张数');
        return false;
    }
    
    var html = this.generateUploaderHtml('', '');
    $('#' + this.containerId).append($(html));
    
    return true;
}




/**
 * @param {} key 此控件的关键字，用于唯一确定此控件
 * @param {} src 初始图片地址
 * @returns {} 生成一个上传控件的html字符串。控件的结构是
 *  <span>
 *     <form>
 *         <img /> <x />
 *         <input type="file"   name="photo" />
 *         <input type="hidden" name="id"    />
 *     </form>
 *     <iframe></iframe>
 *  </span>
 */
ImageUploaderMaker.prototype.generateUploaderHtml = function(src, orgPhotoUrl) {
    var key = this.key + this.currentMaxIndex++;
    
    var html = this.generateImgHtml(key, src, this.ctx) + '\n';
    html    += this.generateXHtml(key, this.ctx) + '\n';
    html    += this.generateInputHtml(key, this.uploaderId);
    
    html     = this.generateFormHtml(key, this.action, html) + '\n';
    html    += this.generateIframeHtml(key);
    
    html     = this.generateSpanHtml(key, html);
    
    this.itemArray.push({
        key: key,
        orgPhotoUrl: orgPhotoUrl,
        status: this.INIT
    });
    
    return html;
}



ImageUploaderMaker.prototype.generateSpanHtml = function(key, innerHTML) {
    var html = '<span style="display:table-cell; padding-right:10px;"\n'
             + '      id="' + key + 'Span">\n'
             + innerHTML
             + '\n</span>';
    return html;
}

    
ImageUploaderMaker.prototype.generateFormHtml = function(key, action, innerHTML) {
    var indent = generateIndentString(1);
    var html = indent + '<form action="' + action + '"\n'
             + indent + '      method="post"\n'
             + indent + '      enctype="multipart/form-data"\n'
             + indent + '      id="' + key + 'Form"\n'
             + indent + '      target="' + key + 'Frame">\n'
             + indent + '    ' + innerHTML + '\n'
             + indent + '</form>';
    return html;
}


ImageUploaderMaker.prototype.generateIframeHtml = function(key) {
    var indent = generateIndentString(1);
    var html = indent + '<iframe id="' + key + 'Frame"\n'
             + indent + '        name="' + key + 'Frame"\n'
             + indent + '        style="display: none;"\n'
             + indent + '        onload="' + this.myId + '.iframeLoad(\'' + key + '\')">\n'
             + indent + '</iframe>';
    return html;
}


ImageUploaderMaker.prototype.generateImgHtml = function(key, src, ctx) {
    var indent = generateIndentString(2);
    var html =          '<img id="' + key + 'Img"\n'
             + indent + '     src="' + src + '"\n'
             + indent + '     class="project-icon"\n'
             + indent + '     style="background:url(' + ctx + '/images/咨询详情/u685.png) no-repeat;\n'
             + indent + '            float:left;"\n'
             + indent + '     onclick="' + key + 'Input.click()" />';
    return html;
}


/**
 * @returns {} 生成红叉
 */
ImageUploaderMaker.prototype.generateXHtml = function(key, ctx) {
    if (!this.showDelete) {
        return '';
    }
    var indent = generateIndentString(2);
    var html = indent + '<!-- 红叉 -->\n'
             + indent + '<img style="margin-left:-10px; margin-top:-10px;float:right;\n'
             + indent + '            background-size: 100% 100%;\n'
             + indent + '            width:20px;\n'
             + indent + '            height:20px;\n'
             + indent + '            border:none;"\n'
             + indent + '     src="' + ctx + '/images/red-x.png"\n'
             + indent + '     onclick="' + this.myId + '.removeUploader(\'' + key + '\')" />'
    return html;
}


ImageUploaderMaker.prototype.generateInputHtml = function(key, idValue) {
    var indent = generateIndentString(2);
    var html = indent + '<input id="' + key + 'Input"\n'
            +  indent + '       type="file"\n'
            +  indent + '       name="photo"\n'
            +  indent + '       onchange="' + this.myId + '.uploadInputChange(\'' + key + '\')"\n'
            +  indent + '       style="display:none" />\n';
    html    += indent + '<input name="id" value="' + idValue + '" type="hidden" />';
    return html;
}


ImageUploaderMaker.prototype.uploadInputChange = function(key) {
    var hasFile = uploaderInputChange(key + 'Input', key + 'Form', key + 'Img');
    if (hasFile) {
        this.setStatusByKey(key, this.UPLOADING);
        $('#' + key + 'Img').attr('src', this.ctx + '/images/uploading.gif');
    }
}


/**
 * 根据key删除此控件
 */
ImageUploaderMaker.prototype.removeUploader = function(key) {
    var id =  key + 'Span';
    $('#' + id).remove();
    
    var index = this.getIndexOfKey(key);
    if (index >= 0) {
        this.itemArray.splice(index, 1);
    }
}


ImageUploaderMaker.prototype.iframeLoad = function(key) {
    var index = this.getIndexOfKey(key);
    if (index < 0) {
        return;
    }
    
    var item = this.itemArray[index];
    var status = item.status;
    switch(status) {
    case this.INIT:
        status = this.NOT_UPLOAD;
        break;
    
    case this.NOT_UPLOAD:
    case this.UPLOAD_ERROR:
    case this.UPLOADING:
        var photo = this.getPhoto(key);
        if (photo == null) {
            status = this.UPLOAD_ERROR;
        } else {
            var photoUrl =  photo.photoUrl;
            if (photoUrl == null || photoUrl == "") {
                status = this.UPLOAD_ERROR;
            } else {
                item.orgPhotoUrl = photoUrl;
                item.photoId = photo.photoId;
                status = this.UPLOAD_SUCCESS;
            }
        }
        break;
    }
    
    item.status = status;
    this.itemArray[index] = item;
    
    setPreview(key + 'Input', key + 'Img') ;
}

    


ImageUploaderMaker.prototype.getIndexOfKey = function(key) {
    for (var index in this.itemArray) {
        var item = this.itemArray[index];
        if (item.key == key) {
            return index;
        }
    }
    return -1;
}


ImageUploaderMaker.prototype.setStatusByKey = function(key, status) {
     var index = this.getIndexOfKey(key);
     if (index < 0) {
         return false;
     }
     
     var success = this.setStatusByIndex(index, status);
     return success;
}


ImageUploaderMaker.prototype.setStatusByIndex = function(index, status) {
     if (index < 0 || index >= this.itemArray.length) {
         return false;
     }
     
     console.log(status);
     var item = this.itemArray[index];
     item.status = status;
     this.itemArray[index] = item;
     
     return true;
}



/**
 * @returns {} 根据key获取此控件的photoUrl
 */
ImageUploaderMaker.prototype.getPhoto = function(key) {
    var frame = document.getElementById(key + 'Frame');
    if (frame == null) {
        return null;
    }
    
    var pre = frame.contentWindow.document.getElementsByTagName('pre');
    if (pre == null || pre.length == 0) {
        return null;
    }
    
    pre = pre[0];
    var result = JSON.parse(pre.innerHTML);
   
    var photoUrl = result.data.photoUrl;
    if (photoUrl == undefined || photoUrl == "") {
        return null;
    }
    
    var photoId = result.data.photoId;
    
    return {photoId: photoId, photoUrl:photoUrl};
}


ImageUploaderMaker.prototype.getPhotoUrlJSONArray = function () {
    console.log('itemArray.length=' + this.itemArray.length);
    
    var photoUrlArray = new Array();
    for (var item in this.itemArray) {
        item = this.itemArray[item];
        var status = item.status;
        
        var photoUrl;
        if (status == this.UPLOADING) {
            console.log("item=" + item);
            alert("图片正在上传中，请耐心等待");
            return null;
        } else if (status == this.UPLOAD_ERROR) {
            console.log("item=" + item);
            alert("上传图片出错");
            return null;
        } else if (status == this.NOT_UPLOAD || status == this.UPLOAD_SUCCESS) {
            photoUrl = item.orgPhotoUrl;
            if (photoUrl == null || photoUrl == "") {
                console.log("item=" + item);
                alert("请上传图片或删除图片空位");
                return null;
            }
        } else {
            console.log("item=" + item);
            continue;
        }
        
        photoUrlArray.push(photoUrl);
    }
    
    
    if (photoUrlArray.length == 0) {
        alert("请至少上传一张图片");
        return null;
    }
    
    
    var photoUrlJSONArray = JSON.stringify(photoUrlArray);
    console.log('photoUrlJSONArray: ' + photoUrlJSONArray);
    return photoUrlJSONArray;
}






ImageUploaderMaker.prototype.getFirstPhotoId = function(){
    var length = this.itemArray.length;
    console.log('itemArray.length=' + length);
    if (length < 1){
        return 0;
    }
    
    var item = this.itemArray[0];
    var status = item.status;
    
    var photoId = 0;
    if (status == this.UPLOADING) {
        console.log("item=" + item);
        alert("图片正在上传中，请耐心等待");
        return null;
    } else if (status == this.UPLOAD_ERROR) {
        console.log("item=" + item);
        alert("上传图片出错");
        return null;
    } else if (status == this.NOT_UPLOAD || status == this.UPLOAD_SUCCESS) {
        photoId = item.photoId;
        if (photoId == undefined){
            return 0;
        }
        if (photoId == 0) {
            console.log("item=" + item);
            alert("上传图片出错");
            return null;
        }
    }
    
    return photoId;
}




//

/*
<span style="display:table-cell;padding-right:10px">
<form action="${ctx}<%=MTWebUris.___UPLOAD %>"
      method="post"
      enctype="multipart/form-data"
      id="doctorIconForm"
      target="doctorIconFrame">
 
    <img id="doctorIconImg"
         src="${doctor.doctorIcon}"
         class="project-icon"
         style="background:url(${ctx}/images/咨询详情/u685.png) no-repeat;
                float:left;"
         onclick="doctorIconInput.click()" />
     
     
     <!-- 红叉 -->
    <img style="margin-left:-10px; margin-top:-10px;float:right;  
                background-size: 100% 100%;
                width:20px;
                height:20px;
                border:none;"
           src="${ctx}/images/red-x.png"
           onclick="alert('haha')"/>
     
    <input id="doctorIconInput"
           type="file"
           name="photo"
           onchange="uploaderInputChange('doctorIconInput', 'doctorIconForm', 'doctorIconImg')"
           style="display:none" />
    <input name="id" value="sdfsf" type="hidden"/>

</form>
<iframe id="doctorIconFrame" name="doctorIconFrame" style="display: none;"></iframe>
</span>
*/


// 
// ImageUploaderMaker
// author: wencheng.song
// -------------------------------------------------------------------------
// -------------------------------------------------------------------------
// -------------------------------------------------------------------------







/**
 * @param {} depth 缩进深度
 * @returns {} 生成缩进的字符串 
 */
function generateIndentString(depth) {
    var s = '';
    while (depth-- > 0) {
        s += '    ';
    }
    return s;
}





// -------------------------------------------------------------------------
// -------------------------------------------------------------------------
// -------------------------------------------------------------------------
// 
// DescriptionItemMaker
// author: wencheng.song

/**
 * 类DescriptionItemMaker：用于生成一个描述项
 * @param {} myId 此生成器自己的id，字符串，必须与new赋值的变量名一致，否则删除按钮可能不好用
 * @param {} ctx 上下文路径
 * @param {} key 关键字
 * @param {} containerId 描述项容器的id，字符串
 * @returns {} 返回一个生成器的实例
 * @用法：
 * <script> 
 * var maker = new DescriptionItemMaker('maker', '${ctx}', '项目介绍', 'intrContainer');
 * </script> 
 * <div id='intrContainer' ></div>
 * 
 * 
 * maker.clickAdd();//点击添加按钮时用
 * maker.generateJsonString();//提交页面表单时生成json格式的字符串
 * 
 */
function DescriptionItemMaker(myId, ctx, key, containerId) {
    this.myId = myId;
    this.ctx = ctx;
    this.key = key;
    this.containerId = containerId;
    
    this.maxCount = 10;
    this.keyArray = new Array();
    this.currentMaxIndex = 0;
}


DescriptionItemMaker.prototype.clickAdd = function() {
    if (this.keyArray.length >= this.maxCount) {
        alert('已达到最大条数');
        return false;
    }
    
    var html = this.generateHtml('', '');
    $('#' + this.containerId).append($(html));
    
    return true;
}


DescriptionItemMaker.prototype.writeHtml = function(jsonArray) {
    for (var item in jsonArray) {
        item = jsonArray[item];
        var html = this.generateHtml(item.title, item.content);
        document.write(html);
    }
}


/**
 * @returns {} 
 * <span>
 *     <input />  <X />
 *     <textarea />
 * </span>
 * @private
 */
DescriptionItemMaker.prototype.generateHtml = function(title, content) {
    var key = this.key + this.currentMaxIndex++;
    var html = this.generateTitleHtml(key, title);
    html += '\n' + this.generateXHtml(key) + '\n';
    html += '\n' + this.generateContentHtml(key, content);
    html = this.generateSpanHtml(key, '\n' + html + '\n');
    this.keyArray.push(key);
    return html;
}

/**
<span class="description-item-span">
<b>标题：</b><input placeholder="标题" class="description-item-title">
<img class="description-item-red-x"
     src="${ctx}/images/red-x.png"
     onclick="alert('haha')"/>
<br/>
<b>描述：</b><br/>
<textarea placeholder="描述"
          type="text"
          class="description-item-content">adsfasdfasdfasdfsd</textarea>
</span>
 */


/**
 * @private
 */
DescriptionItemMaker.prototype.generateSpanHtml = function(key, innerHTML) {
    var html = '<span id="' + key + 'Span" class="description-item-span">\n'
            +  innerHTML
            + '\n</span>';
    return html;
}


/**
 * @private
 */
DescriptionItemMaker.prototype.generateTitleHtml = function(key, title) {
    var indent = generateIndentString(1);
    var html = indent + '<b>标题：</b>\n'
             + indent + '<input id="' + key + 'TitleInput"\n'
             + indent + '       placeholder="标题"\n'
             + indent + '       class="description-item-title" \n'
             + indent + '       value="' + title + '" />';
    return html;
}


/**
 * @private
 */
DescriptionItemMaker.prototype.generateXHtml = function(key) {
    var indent = generateIndentString(1);
    var html = indent + '<img class="description-item-red-x"\n'
             + indent + '     src="' + this.ctx + '/images/red-x.png"\n'
             + indent + '     onclick="' + this.myId + '.clickRemove(\'' + key + '\')" />\n'
             + indent + '<br/>';
    return html;
}


/**
 * @private
 */
DescriptionItemMaker.prototype.generateContentHtml = function(key, content) {
    var indent = generateIndentString(1);
    var id = key + 'Textarea';
    var html = indent + '<b>内容：</b><br/>\n'
             + indent + '<textarea id="' + id + '"\n'
             + indent + '          placeholder="内容"\n'
             + indent + '          class="description-item-content"\n'
             + indent + '>' + content + '</textarea>\n';
    
    html += indent + '<script type="text/javascript">\n'
          + indent + '    var textarea = getElementById("' + id + '");\n'
          + indent + '    if (textarea != null) {\n'
          + indent + '        autoTextarea(textarea);\n'
          + indent + '    }\n'
          + indent + '</script>';
    
    return html;
}


/**
 * @private
 */
DescriptionItemMaker.prototype.clickRemove = function(key) {
    var id =  key + 'Span';
    $('#' + id).remove();
    
    for (var index in this.keyArray) {
        var k = this.keyArray[index];
        if (k == key) {
            this.keyArray.splice(index, 1);
            return ;
        }
    }
}

/**
 * 生成jsonString
 */
DescriptionItemMaker.prototype.generateJsonString = function() {
    var array = new Array();
    for (var key in this.keyArray) {
        key = this.keyArray[key];
        var titleInput = getElementById(key + 'TitleInput');
        if (titleInput == null) {
            return null;
        }
        var title = titleInput.value;
        var content = $('#' + key + 'Textarea').val();
        if (title == "" && content == "") {
            alert(this.key + '中，标题 和 内容 不能同时为空');
            titleInput.focus();
            return null;
        }
        array.push({
            title: title,
            content: content
        });
    }
    
    if (array.length == 0) {
        alert("请输入至少一条" + this.key);
        $('#' + this.containerId).focus();
        return null;
    }
    
    var jsonString = JSON.stringify(array);
    console.log(jsonString);
    return jsonString;
}



// 
// DescriptionItemMaker
// author: wencheng.song
//
// -------------------------------------------------------------------------
// -------------------------------------------------------------------------
// -------------------------------------------------------------------------




/**
 * 文本框根据输入内容自适应高度。前端调用时，可以只输入elem参数
 * @param                {HTMLElement}           输入框元素
 * @param                {Number}                设置光标与输入框保持的距离(默认0)
 * @param                {Number}                设置最大高度(可选)
 */
var autoTextarea = function (elem, extra, maxHeight) {
        extra = extra || 0;
        var isFirefox = !!document.getBoxObjectFor || 'mozInnerScreenX' in window,
        isOpera = !!window.opera && !!window.opera.toString().indexOf('Opera'),
                addEvent = function (type, callback) {
                        elem.addEventListener ?
                                elem.addEventListener(type, callback, false) :
                                elem.attachEvent('on' + type, callback);
                },
                getStyle = elem.currentStyle ? function (name) {
                        var val = elem.currentStyle[name];
    
                        if (name === 'height' && val.search(/px/i) !== 1) {
                                var rect = elem.getBoundingClientRect();
                                return rect.bottom - rect.top -
                                        parseFloat(getStyle('paddingTop')) -
                                        parseFloat(getStyle('paddingBottom')) + 'px';        
                        };
    
                        return val;
                } : function (name) {
                        return getComputedStyle(elem, null)[name];
                },
                minHeight = parseFloat(getStyle('height'));
     
        elem.style.resize = 'none';
    
        var change = function () {
                var scrollTop, height,
                        padding = 0,
                        style = elem.style;
 
                if (elem._length === elem.value.length) return;
                elem._length = elem.value.length;
 
                if (!isFirefox && !isOpera) {
                        padding = parseInt(getStyle('paddingTop')) + parseInt(getStyle('paddingBottom'));
                };
                scrollTop = document.body.scrollTop || document.documentElement.scrollTop;
 
                elem.style.height = minHeight + 'px';
                if (elem.scrollHeight > minHeight) {
                        if (maxHeight && elem.scrollHeight > maxHeight) {
                                height = maxHeight - padding;
                                style.overflowY = 'auto';
                        } else {
                                height = elem.scrollHeight - padding;
                                style.overflowY = 'hidden';
                        };
                        style.height = height + 9 + extra + 'px';
                        scrollTop += parseInt(style.height) - elem.currHeight;
                        document.body.scrollTop = scrollTop;
                        document.documentElement.scrollTop = scrollTop;
                        elem.currHeight = parseInt(style.height);
                };
        };
    
        addEvent('propertychange', change);
        addEvent('input', change);
        addEvent('focus', change);
        change();
};




function getSelect(key) {
    var id = key + 'Select';
    var select = getElementById(id);
    return select;
}





var CURSOR_AUTO = "auto";
var CURSOR_PROGRESS = "progress";
function setBodyCursor(cursor){
	document.body.style.cursor = cursor;
}






function sendAjax(url, data, type, success, error, shouldAlertError) {
	setBodyCursor(CURSOR_PROGRESS);
	
    if (type == undefined) {
        type = 'GET';
    }
    
    if (shouldAlertError == undefined) {
    	shouldAlertError = true;
    }
    
    
    var info = type + ' ajax请求:' + url + ', data=' + data;
    console.log(info);
    
    var executeErrorFunction = function(data) {
        if (error) {
            error(data);
        }
        setBodyCursor(CURSOR_AUTO);
    };
    
    $.ajax({
        type: type,
        url:url,
        data: data,
        success: function(data) {
            console.log('解析请求返回结果：' + info + ':' + data);
            var status = data.status;
            if (status == undefined) {
                alert('请求失败:' + info);
                executeErrorFunction(data);
                return ;
            }
            
            var code = status.code;
            if (code != 0) {
                var msg = status.msg;
                if (shouldAlertError) {
                    alert(msg);
                }
                executeErrorFunction(data);
                return ;
            }
            
            console.log('解析成功：' + info + ':' + data);
            data = data.data;
            
            setBodyCursor(CURSOR_AUTO);
            success(data);
        },
        error: function(data) {
            console.log('请求失败：' + info + ':' + data);
            executeErrorFunction(data);
        }
    });
}














var MONEY_REG = new RegExp("^(([1-9]+[0-9]*.{1}[0-9]+)|([0].{1}[1-9]+[0-9]*)|([1-9][0-9]*)|([0][.][0-9]+[1-9]*))$");
function checkMoney(input) {
    if (input == null) {
        return null;
    }
    var value = input.value;
    if (MONEY_REG.test(value)) {
        return value;
    }
    alert("请输入正确的金额");
    input.focus();
    return null;
} 



function checkAndSetMoneyInput(inputToSet, moneyInput) {
    if (inputToSet == null) {
        return false;
    }
    var value = checkMoney(moneyInput);
    if (value == null) {
        return false;
    }
    inputToSet.value = value;
    return true;
}







/**
 * @param select
 *            select控件
 * @returns 返回select控件选中项的文本
 */
function getSelectText(select) {
    if (select == null) {
        return null;
    }
    var index = select.selectedIndex;
    if (index < 0 || index == undefined) {
        return null;
    }
    var text = select.options[index].text;
    return text;
}







function getNodeInArray(array, value, field) {
    if (array == null || value == null || field == null) {
        return null;
    }
    
    for (var node in array) {
        node = array[node];
        if (node == null) {
            continue;
        }
        
        if (node[field] == value) {
            return node;
        }
    }
    
    return null;
}




function generateSelectHtml(array, key, valueField, displayField, indent, onchange) {
    if (array == null || key == null || valueField == null) {
        return null;
    }
    
    if (displayField == null) {
        displayField = valueField;
    }
    
    if (indent == null || indent<0) {
        indent = 0;
    }
    indent = generateIndentString(indent);
    
    var html  = indent + '<select id="' + key + 'Select"';
    if (onchange != null) {
        html += '\n'
              + indent + '        onchange="' + onchange + '"'
    }
    html += '>\n';
    html     += indent + '    <option value="0">请选择</option>\n';
    for (var node in array) {
        node = array[node];
        var value = node[valueField];
        var display = node[displayField];
        html += indent + '    <option value="' + value + '">' + display + '</option>\n';
    }
    html     += indent + '</select>';
    return html;
}






function fullColSpan(td) {
    if (td == null) {
        return ;
    }
    var rowsCount = td.offsetParent.rows.length;
    var maxColumnCount = 0;
    for (var i = 0; i < rowsCount; i++){
        var columnCount = td.offsetParent.rows[i].cells.length;
        if (columnCount > maxColumnCount){
        	maxColumnCount = columnCount;
        }
    }
    td.colSpan = maxColumnCount;
}






















//-------------------------------------------------------------------------
//-------------------------------------------------------------------------
//-------------------------------------------------------------------------
//
//IosExtraMaker
//author: wencheng.song

/**
 * 类IosExtraMaker：用于生成ios extra
 * @param {} myId 此生成器自己的id，字符串，必须与new赋值的变量名一致，否则删除按钮可能不好用
 * @param {} ctx 上下文路径
 * @param {} key 关键字
 * @param {} containerId 描述项容器的id，字符串
 * @param {} readonly 是否只读。如果只读，则不生成红叉，且K-V不可编辑。
 * @returns {} 返回一个生成器的实例
 * @用法：
 * <script> 
 * var maker = new IosExtraMaker('maker', '${ctx}', 'iosExtra', 'iosExtraContainer', false);
 * </script> 
 * <div id='iosExtraContainer' ></div>
 * 
 * 
 * maker.clickAdd();//点击添加按钮时用
 * maker.generateJsonString();//提交页面表单时生成json格式的字符串
 * 
 */
function IosExtraMaker(myId, ctx, key, containerId, readonly) {
    this.myId = myId;
    this.ctx = ctx;
    this.key = key;
    this.containerId = containerId;
    this.readonly = (readonly == undefined) ? false : readonly;
 
    this.maxCount = 10;
    this.itemArray = [];
    this.currentMaxIndex = 0;
}


IosExtraMaker.prototype.clickAdd = function() {
    if (this.readonly) {
        console.log('readonly');
        return false;
    }
    
    if (this.itemArray.length >= this.maxCount) {
        alert('已达到最大条数:' + this.maxCount);
        return false;
    }

    var html = this.generateHtml('', '');
    $('#' + this.containerId).append($(html));

    return true;
}


IosExtraMaker.prototype.writeHtml = function(jsonArray) {
    for (var jsonKey in jsonArray) {
        var jsonValue = jsonArray[jsonKey];
        var html = this.generateHtml(jsonKey, jsonValue);
        document.write(html);
    }
}


/**
 * <span>
 *     <input /> <input /> <X />
 * </span>
 * @private
 */
IosExtraMaker.prototype.generateHtml = function(jsonKey, jsonValue) {
    var key = this.key + this.currentMaxIndex++;
    var html = this.generateInputHtml(key, 'key', jsonKey);
    html += '\n' + this.generateInputHtml(key, 'value', jsonValue);
    html += '\n' + this.generateXHtml(key) + '\n';
    html = this.generateSpanHtml(key, '\n' + html + '\n');
    var item = {
        key: key,
        jsonKey: jsonKey,
        jsonValue: jsonValue
    };
    this.itemArray.push(item);
    return html;
}

/**
 * @private
 */
IosExtraMaker.prototype.generateSpanHtml = function(key, innerHTML) {
    var html = '<span id="' + key + 'Span" class="kv-item-span">\n'
            +  innerHTML
            + '\n</span>';
    return html;
}


/**
* @private
*/
IosExtraMaker.prototype.generateInputHtml = function(key, type, inputValue) {
    var indent = generateIndentString(1);
    var html;
    
    if (this.readonly) {
    	html = indent + '<span class="kvinput"\n'
    	     + indent + '      style="display:inline-block;\n'
    	     + indent + '             border: 1px solid #aaaaaa;">' + inputValue + '</span>';
    } else {
        html = indent + '<input id="' + key + type + 'Input"\n'
             + indent + '       placeholder="' + type + '"\n'
             + indent + '       class="kvinput"\n'
             + indent + '       value="' + inputValue + '" />\n';
    }
    return html;
}


/**
* @private
*/
IosExtraMaker.prototype.generateXHtml = function(key) {
	if (this.readonly) {
		return '<br/>';
	}
	
    var indent = generateIndentString(1);
    var html = indent + '<img class="red-x"\n'
             + indent + '     src="' + this.ctx + '/images/red-x.png"\n'
             + indent + '     onclick="' + this.myId + '.clickRemove(\'' + key + '\')" />\n'
             + indent + '<br/>';
    return html;
}



/**
* @private
*/
IosExtraMaker.prototype.clickRemove = function(key) {
	if (this.readonly) {
		return ;
	}
	
    var id =  key + 'Span';
    $('#' + id).remove();
    
    for (var index in this.itemArray) {
        var item = this.itemArray[index];
        if (item.key == key) {
            this.itemArray.splice(index, 1);
            return ;
        }
    }
}

/**
* 生成jsonString
*/
IosExtraMaker.prototype.generateJsonString = function() {
    var iosExtra = {};
    for (var item in this.itemArray) {
    	item = this.itemArray[item];
    	var key = item.key;
        
        var jsonKey = checkAndGetValue(key + 'keyInput', "KEY", 50);
        if (jsonKey == null) {
            return null;
        }
    
        var jsonValue = checkAndGetValue(key + 'valueInput', "VALUE", 50);
        if (jsonValue == null) {
            return null;
        }
    
        
        iosExtra[jsonKey] = jsonValue;
    }
    
    var jsonString = JSON.stringify(iosExtra);
    console.log(jsonString);
    return jsonString;
}


//
//IosExtraMaker
//author: wencheng.song
//
//-------------------------------------------------------------------------
//-------------------------------------------------------------------------
//-------------------------------------------------------------------------









/**
 * @returns 
 */
function getFileUploadPath(frame) {
	var pre;
    
    try{
    	pre = frame.document.getElementsByTagName('pre');
    }catch(e){
    	return null;
    }
    
    if (pre == null || pre.length == 0) {
        return null;
    }
    
    pre = pre[0];
    var result = JSON.parse(pre.innerHTML);
   
    var path = result.data.path;
    if (path == undefined || path == "") {
        return null;
    }
    
    return path;
}

/**
 * 文件大小
 */
var MAX_M_SIZE = 1;
function checkUploadFile(input) {
    try {
        var maxsize = MAX_M_SIZE * 1024 * 1024;
        var obj_file = input;
        var filesize = obj_file.files[0].size;
        if(filesize >= maxsize) {
            alert("文件大小不能超过 " + MAX_M_SIZE +" M!");
            return false;
        }
    }catch(e){
    }
    return true;
}

/**
 * 检查selectId对应的值是否是数字
 * @param selectId
 * @returns 
 */
function checkIsNaN(selectId,alertMsg){
	var element=getElementById(selectId);
	if(element==null){
		return false;
	}
	
	if(isNaN(element.value)){
		alert(alertMsg);
		return false;
	}
	
	return true;
}
