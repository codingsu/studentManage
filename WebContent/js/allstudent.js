/**
 * 
 */
var TableEditable = function() {

	return {
		// main function to initiate the module
		init : function() {
//			function restoreRow(oTable, nRow) {
//			var aData = oTable.fnGetData(nRow);
//				var jqTds = $('>td', nRow);
//				for (var i = 0, iLen = jqTds.length; i < iLen; i++) {
//				oTable.fnUpdate(aData[i], nRow, i, false);
//				}
//				oTable.fnDraw();
//			}
			var oTable = $('#customer_editable_1').dataTable({
				"aLengthMenu" : [ [ 10, 15, 20, -1 ], [ 10, 15, 20, "所有" ] // change
				// per
				// page
				// values
				// here
				],
				"bPaginate" : true,
				// set the initial value
				"iDisplayLength" : 10,// 用于指定一屏显示的条数，需开启分页器
				"sPaginationType" : "bootstrap",// 指定分页风格

				"oLanguage" : {// 改变语言
					"sLengthMenu" : "_MENU_ 条",
					"sSearch" : "搜索",// 没搞懂
					"sInfo" : "从 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
					"sEmptyTable" : "没有任何记录",
					"sInfoEmpty" : "共0条记录",
					"sInfoFiltered" : "(从共 _MAX_ 条记录中过滤)",
					"oPaginate" : {
						"sFirst" : "首页",
						"sPrevious" : "Prev",
						"sNext" : "Next",
						"sLast" : "尾页"
					}
				},
				
				//不允许排序的列
				"aoColumnDefs": [{
                    'bSortable': false,
                    'aTargets': [1]
                }]
			});
		//	 oTable.fnSort([[9, 'asc']]);
			//添加样式
		    jQuery('#customer_editable_1_wrapper .dataTables_filter input')
					.addClass("form-control input-medium input-inline");
			jQuery('#customer_editable_1_wrapper .dataTables_length select')
					.addClass("form-control input-small");
			jQuery('#customer_editable_1_wrapper .dataTables_length select')
					.select2({
						showSearchInput : false
					// hide search box with special css
					// class
					}); // initialize select2 dropdown

		}
	};
}();