<%@ page language="java" pageEncoding="UTF-8"%>
<div class="head-package">
	<div id="head-parent" class="head-parent">	
		<div class="menu-parent">
			<ul class="sub-menu">
				<li class="sub-item"><a href="javascript:void(0)" onclick="redirect('page/home')">首页</a></li>
				<li class="sub-item"><a href="javascript:void(0)" onclick="redirect('page/teaching/cartoon')" onmouseover="showBar('1')">教学</a></li>
				<li class="sub-item"><a href="javascript:void(0)" onclick="redirect('page/review/blog')" onmouseover="showBar('2')">复盘</a></li>
				<li class="sub-item"><a href="javascript:void(0)" onclick="redirect('page/software/instruction')" onmouseover="showBar('3')">缠论指标</a></li>
			</ul>
		</div>
	</div>
	<div id="triangle-down"></div>
	<div id="head-sub" class="head-sub">
		<a href="page/home">
			<div class="logo">
				<img src="resources/imgs/header-black.png" height="80" />
			</div>
			<div class="title">
				<span class="title-main">缠&nbsp;论&nbsp;君</span><br/>
				<span class="title-sub">缠论第一站</span>
			</div>
		</a>
		<div id="menu-second-1" class="menu-second" style="display:none">
			<ul class="sub-menu">
				<li class="sub-item"><a id="i1" href="javascript:void(0)" onclick="redirect('page/teaching/cartoon')">从零开始学<br/>缠论漫画</a></li>
				<li class="sub-item"><a id="i2" href="javascript:void(0)" onclick="redirect('page/teaching/video')">从零开始学<br/>缠论视频</a></li>
				<li class="sub-item"><a id="i3" href="javascript:void(0)" onclick="coming()">第二本缠<br/>论教学</a></li>
				<li class="sub-item"><a id="i4" href="javascript:void(0)" onclick="coming()">第三本缠<br/>论教学</a></li>
				<li class="sub-item"><a id="i5" href="javascript:void(0)" onclick="coming()">收费缠论<br/>教学</a></li>
			</ul>
		</div>
		
		<div id="menu-second-2" class="menu-second" style="display:none">
			<ul class="sub-menu">
				<li class="sub-item"><a id="f1" href="javascript:void(0)" onclick="redirect('page/review/blog')">复盘<br/>博文</a></li>
				<li class="sub-item"><a id="f2" href="javascript:void(0)" onclick="redirect('page/review/video')">复盘教学<br/>视频</a></li>
			</ul>
		</div>
		
		<div id="menu-second-3" class="menu-second" style="display:none">
			<ul class="sub-menu">
				<li class="sub-item"><a id="s1" href="javascript:void(0)" onclick="redirect('page/software/instruction')">缠论<br/>指标</a></li>
			</ul>
		</div>
	</div>
</div>