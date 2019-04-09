# Introduction

## 注意
2019年3月份阅读源码时，一些浏览器如（chrome）会把http换成https
故使用`Internet Explorer 11`

> chrome版本如下
```html
Google Chrome	72.0.3622.0 (正式版本) （32 位） 
修订版本	74770d660797220710701b2c66ad38390ab86d43-refs/branch-heads/3622@{#1}
操作系统	Windows
JavaScript	V8 7.2.468
Flash	32.0.0.142 C:\Users\Chen\AppData\Local\Google\Chrome\User Data\PepperFlash\32.0.0.142\pepflashplayer.dll
用户代理	Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3622.0 Safari/537.36
命令行	"C:\Users\Chen\AppData\Local\Google\Chrome\Application\chrome.exe" --flag-switches-begin --flag-switches-end
可执行文件路径	C:\Users\Chen\AppData\Local\Google\Chrome\Application\chrome.exe
个人资料路径	C:\Users\Chen\AppData\Local\Google\Chrome\User Data\Default
```
> 可以设置一下chrome不将指定域名加https
![参考](https://www.cnblogs.com/linhongwenBlog/p/8697811.html)

1.地址栏输入： `chrome://net-internals/#hsts`
2.在打开的页面中， `Delete domain`栏的输入框中输入要`http`访问的域名，然后点击`delete`按钮，即可完成配置。然后你可以在`Query domain`栏中搜索刚才输入的域名，点击`query`按钮后如果提示`Not found`，那么你现在就可以使用`http`来访问我的网站了！