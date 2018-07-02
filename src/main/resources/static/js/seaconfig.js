seajs.config({
	paths :{
		'lib': 'lib',
		'bus': 'bus',
	},
	alias: {
		'jquery': 'lib/jquery.min.js',
		'jquery-core': 'lib/jquery.ui.core.js',
		'jquery-widget': 'lib/jquery.ui.widget.js',
		'jquery-form': 'lib/jquery.ui.form.js',
		
		'index': 'bus/index',
		'login':  'bus/login',
		'register': 'bus/register',
		'forgetPwd': 'bus/forgetPwd',
		'resetPwd': 'bus/resetPwd',
	},
	preload:[
	    'jquery'
	],
	charset: 'utf-8'
});