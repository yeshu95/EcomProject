$(document).ready( function () {
	 var table = $('#categoryTable').DataTable({
			"sAjaxSource": "categorys",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			    { "mData": "categoryid"},
		      { "mData": "categoryname" }
		      
							 
			]
	 });
	  var table = $('#supplierTable').DataTable({
			"sAjaxSource": "suppliers",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			    { "mData": "suplierid"},
		      { "mData": "suppliername" }
		      
							 
			]
	 });
});