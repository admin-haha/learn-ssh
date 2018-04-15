function openBrowserWindow(width, height, url) {
	openNewBrowserWindow('BrowserWindow', width, height, url)
}

function openNewBrowserWindow(id, width, height, url) {
	var left = (screen.width - width) / 2;
	var top = (screen.height - height) / 2;
	var position = 'width=' + width + ', height=' + height + ', left=' + left
			+ ', top=' + top;
	window
			.open(
					url,
					id,
					'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=yes, resizable=no, ' + position);
}

function checkAll(element, itemName) {
	var item = document.getElementsByName(itemName);
	for ( var i = 0; i < item.length; i++) {
		item[i].checked = element.checked;
	}
}

function validateNumber(number) {
	var regex = /^[0-9]*(\.[0-9]{1,3})?$/;
	return regex.test(number);
}

function validateNum(number) {
	var regex = /^[0-9]*(\.[0-9]{1,2})?$/;
	return regex.test(number);
}

function openWindow(width, height, url) {
	var left = (screen.width - width) / 2;
	var top = (screen.height - height) / 2;
	var position = 'width=' + width + ', height=' + height + ', left=' + left
			+ ', top=' + top;
	window
			.open(
					url,
					'channeltree_window',
					'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=yes,' + position);

}

function openMyWindow(width, height, url) {
	var left = (screen.width - width) / 2;
	var top = (screen.height - height) / 2;
	var position = 'width=' + width + ', height=' + height + ', left=' + left
			+ ', top=' + top;
	window
			.open(
					url,
					'channeltree_window',
					'toolbar=no, location=no,outerHeight=0,outerWidth=0,directories=no, directories=no, status=no, menubar=no, scrollbars=no,z-look=yes,' + position);

}

function openNewWindow(width, height, url, winName) {
	var left = (screen.width - width) / 2;
	var top = (screen.height - height) / 2;
	var position = 'width=' + width + ', height=' + height + ', left=' + left
			+ ', top=' + top;
	window
			.open(
					url,
					winName,
					'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=yes,' + position);

}

function selectAll(o1, o2) {
	var obj1 = document.getElementsByName(o1)[0];
	var obj2 = document.getElementsByName(o2);
	for ( var i = 0; i < obj2.length; i++) {
		if (obj1.checked) {
			if (obj2[i].type == "checkbox") {
				obj2[i].checked = true;
			}
		} else {
			if (obj2[i].type == "checkbox") {
				obj2[i].checked = false;
			}
		}
	}
}

function clearCheckedBox(o1) {
	if (document.getElementById(o1)) {
		document.getElementById(o1).checked = '';
	}
}

function selectOne(o1, o2) {
	var ischecked = false;
	for ( var i = 0; i < document.getElementsByName(o2).length; i++) {
		if (document.getElementsByName(o2)[i].checked) {
			ischecked = true;
			break;
		}
	}
	if (ischecked) {
		document.getElementById(o1).checked = 'checked';
	} else {
		document.getElementById(o1).checked = '';
	}
}

function inputFocus(textInput){
    var memberNoDefault = "所有会员";
    if (textInput.value == memberNoDefault) {
        textInput.value = '';
    } else {
        if (textInput.value.length <= 0) {
            textInput.value = memberNoDefault;
            document.getElementById("memberStatus").value=0;
        }else{
            document.getElementById("memberStatus").value=1;
        }
    }
    
    if (textInput.value == memberNoDefault) {
        textInput.style.color = "gray";
    } else {
        textInput.style.color = "black";
    }
}

function clearAllCheckBox(itemName) {
	var item = document.getElementsByName(itemName);
	for ( var i = 0; i < item.length; i++) {
		item[i].checked = false;
	}
}

function getBodyTop() {
	var bodyTop = 0;
	if (typeof window.pageYOffset != 'undefined') {
		bodyTop = window.pageYOffset;
	} else if (typeof document.compatMode != 'undefined'
			&& document.compatMode != 'BackCompat') {
		bodyTop = document.documentElement.scrollTop;
	} else if (typeof document.body != 'undefined') {
		bodyTop = document.body.scrollTop;
	}
	return bodyTop;
}

function myOpen(url, width, height) {
	// 自动适应高度和宽度，传0进来
	if (width == undefined || width <= 0) {
		width = screen.width - 120;
	}
	if (height == undefined || height <= 0) {
		height = screen.height - 80;
	}

	var w_left = screen.width / 2 - (width / 2);
	var w_height = screen.height / 2 - (height / 2);
	var changeWindow = window.open(url, '', 'scrollbars=yes,width=' + width
			+ ',height=' + height + ', left=' + w_left + ', top=' + w_height);
	// changeWindow.moveTo(w_left, w_height);
	// changeWindow.resizeTo(width, height);
}



function myOpenByName(url, name , width, height) {
	// 自动适应高度和宽度，传0进来
	if (width == undefined || width <= 0) {
		width = screen.width - 120;
	}
	if (height == undefined || height <= 0) {
		height = screen.height - 80;
	}

	var w_left = screen.width / 2 - (width / 2);
	var w_height = screen.height / 2 - (height / 2);
	var changeWindow = window.open(url, name, 'scrollbars=yes,width=' + width
			+ ',height=' + height + ', left=' + w_left + ', top=' + w_height);
	// changeWindow.moveTo(w_left, w_height);
	// changeWindow.resizeTo(width, height);
}


function myOpenPopup(url, width, height, top, left, id) {
	// 自动适应高度和宽度，传0进来
	if (width == undefined || width <= 0) {
		width = document.body.clientWidth - 120;
	}
	if (height == undefined || height <= 0) {
		height = document.body.clientHeight - 80;
	}

	var iframeHtml = "<iframe src='" + url + "'  id='" + id
			+ "' height='100%' width='100%' frameborder='0'></iframe>";
	createWindow(id, width, height, '#D6E1F5', iframeHtml, id, 0, left, top);

}

function printOpen(url, width, height) {
	// 自动适应高度和宽度，传0进来
	if (width == undefined || width <= 0) {
		width = screen.width - 120;
	}
	if (height == undefined || height <= 0) {
		height = screen.height - 80;
	}

	var w_left = screen.width / 2 - (width / 2);
	var w_height = screen.height / 2 - (height / 2);
	var changeWindow = window.open(url, '', 'scrollbars=yes,menubar=yes,width='
			+ width + ',height=' + height);
	changeWindow.moveTo(w_left, w_height);
	changeWindow.resizeTo(width, height);
}

function getRaidoValue(controlName) {
	radios = document.getElementsByName(controlName);
	for (i = 0; i < radios.length; i++) {
		if (radios[i].checked == true) {
			return radios[i].value;
		}
	}

	return '';
}

function checkRadio(radioName, value) {
	radios = document.getElementsByName(radioName);
	for ( var i = 0; i < radios.length; i++) {
		if (radios[i].value == value) {
			radios[i].checked = true;
			return;
		}
	}
}

function selectOption(selectControlName, value) {
	if (document.getElementById(selectControlName)) {
		allOptions = document.getElementById(selectControlName).options;
		for ( var i = 0; i < allOptions.length; i++) {
			if (allOptions[i].value == value) {
				allOptions[i].selected = true;
				return;
			}
		}
	}
}

function clearFormElement(tagId, tagName) {
	var element = $('#' + tagId);
	if (element && tagName == 'text') {
		$('#' + tagId).val('');
	}
}

function checkName(o) {
	var s = o.value;
	if (s != null) {
		s = s.replace(/[%&@!#^;=?$\x22\x27]/g, '');
		o.value = s;
	}
}

function checkEnglishName(o) {
	var s = o.value;
	if (s != null) {
		s = s.replace(/[^A-Za-z0-9 ]/g, '');
		o.value = s;
	}
}
function checkCode(o) {
	var s = o.value;
	if (s != null) {
		s = s.replace(/[^A-Za-z0-9-_()——]/g, '');
		o.value = s;
	}
}

function getJobLastProcessTime(jobId, spanId) {
	var urlStr = '/jml/commonAjax/getJobLastProcessTime.fbi';
	$.post(urlStr, {
		jobId :jobId
	}, function(data) {
		if (data) {
			document.getElementById(spanId).innerHTML = data.trim();
		}
	});
}

function getDataLastProcessTime(id, spanId) {
	var urlStr = '/jml/commonAjax/getDataLastProcessTime.fbi';
	$.post(urlStr, {
		id :id
	}, function(data) {
		if (data) {
			document.getElementById(spanId).innerHTML = data.trim();
		}
	});
}

function getServerTime() {
	var showtime = new Date().format("yyyyMMddhhmm");
	// 200912241001
	url = "/common/gettime.jsp?time=" + showtime;
	var data = $.ajax( {
		url :url,
		async :false
	}).responseText;
	if (data == null || data.length != 12) {
		return showtime;
	}

	return data;
}

function ServerTime() {
	var data = getServerTime();
	// alert(data);
	var yyyy = parseInt(data.substr(0, 4));
	var MM = parseInt(data.substr(4, 2)) - 1;
	var dd = parseInt(data.substr(6, 2));
	var hh = parseInt(data.substr(8, 2));
	var mi = parseInt(data.substr(10, 2));
	// alert(yyyy + '-' + MM + '-' + dd);
	return (new Date(yyyy, MM, dd, hh, mi, 0, 0));
}
// 打开上传图片窗口
function open_upImage_window(fileId, maxSize) {
	myOpen('/jml/UpImage/open_up_image.fbi?fileId=' + fileId + '&maxSize='
			+ maxSize, 450, 450);
}

// 显示图片窗口
function show_image_window(picturePath) {
	myOpen('/jml/UpImage/show_image.fbi?picturePath=' + picturePath, 450, 450);
}

function getJobLastProcessTime(jobId, spanId) {
	var url = '/jml/commonAjax/getJobLastProcessTime.fbi';

	$.post(url, {
		jobId :jobId
	}, function(data) {
		if (data) {
			$('#' + spanId).html(data.trim());
		}
	});
}

function getStringBLength(str){
	return str.replace(/[^\x00-\xFF]/g,'**').length;
}

function getLengthStr(str, length){
	var subStr = '';
	var regu = '[^\x00-\xFF]';
	var re = new RegExp(regu);
	var number = 0;
	for(var i = 0; i < str.length; i ++){
		if (str.charAt(i).search(re) != -1){
			number = number + 2;
		} else {
			number = number + 1;
		}
		if (number <= length){
			subStr = subStr + str.charAt(i);
		} else {
			break;
		}
	}
	return subStr;
}

/**
 * 得到请求中的参数 name:参数名import by tingfeng
 */
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null)
	return unescape(r[2]);
    return null;
}
function limitByteAboutInput(idName, limitByteLenth) {
    $("#" + idName).keydown(function() {
        CutStr(this, limitByteLenth);
    }).keyup(function() {
        CutStr(this, limitByteLenth);
    });
}
//判断字符串所占的字节数
function GetCharLength(str) {
    var iLength = 0; //记录字符的字节数
    for (var i = 0; i < str.length; i++) //遍历字符串中的每个字符
    {
        if (str.charCodeAt(i) > 255) //如果当前字符的编码大于255
        {
            iLength += 2; //所占字节数加2
        } else {
            iLength += 1; //否则所占字节数加1
        }
    }
    return iLength; //返回字符所占字节数
}

//若字符串长度超过要求，截掉多余部分
function CutStr(element, len) //elementID表示要进行处理的对象ID,len表示设置的限制字节数
{
    //alert(3434);
    var str = element.value; //获取要处理的字符串
    var curStr = ""; //用于实时存储字符串
    for (var i = 0; i < str.length; i++) //遍历整个字符串
    {
        curStr += str.charAt(i); //记录当前遍历过的所有字符
        if (GetCharLength(curStr) > len) //如果当前字符串超过限制长度
        {
            element.value = str.substring(0, i); //截取多余的字符,并把剩余字符串赋给要进行处理的对象
            return; //结束函数
        }
    }
}
