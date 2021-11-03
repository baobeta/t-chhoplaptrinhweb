<!-- BEGIN PAGE CONTAINER -->
<div class="page-container">
  <!-- BEGIN PAGE HEAD -->
  <div class="page-head">
    <div class="container">
      <!-- BEGIN PAGE TITLE -->
      <div class="page-title">
        <h1>Managed Datatables <small>managed datatable samples</small></h1>
      </div>
      <!-- END PAGE TITLE -->
      <!-- BEGIN PAGE TOOLBAR -->
      <div class="page-toolbar">
        <!-- BEGIN THEME PANEL -->
        <div class="btn-group btn-theme-panel">
          <a href="javascript:;" class="btn dropdown-toggle" data-toggle="dropdown">
            <i class="icon-settings"></i>
          </a>
          <div class="dropdown-menu theme-panel pull-right dropdown-custom hold-on-click">
            <div class="row">
              <div class="col-md-6 col-sm-6 col-xs-12">
                <h3>THEME COLORS</h3>
                <div class="row">
                  <div class="col-md-6 col-sm-6 col-xs-12">
                    <ul class="theme-colors">
                      <li class="theme-color theme-color-default" data-theme="default">
                        <span class="theme-color-view"></span>
                        <span class="theme-color-name">Default</span>
                      </li>
                      <li class="theme-color theme-color-blue-hoki" data-theme="blue-hoki">
                        <span class="theme-color-view"></span>
                        <span class="theme-color-name">Blue Hoki</span>
                      </li>
                      <li class="theme-color theme-color-blue-steel" data-theme="blue-steel">
                        <span class="theme-color-view"></span>
                        <span class="theme-color-name">Blue Steel</span>
                      </li>
                      <li class="theme-color theme-color-yellow-orange" data-theme="yellow-orange">
                        <span class="theme-color-view"></span>
                        <span class="theme-color-name">Orange</span>
                      </li>
                      <li class="theme-color theme-color-yellow-crusta" data-theme="yellow-crusta">
                        <span class="theme-color-view"></span>
                        <span class="theme-color-name">Yellow Crusta</span>
                      </li>
                    </ul>
                  </div>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                    <ul class="theme-colors">
                      <li class="theme-color theme-color-green-haze" data-theme="green-haze">
                        <span class="theme-color-view"></span>
                        <span class="theme-color-name">Green Haze</span>
                      </li>
                      <li class="theme-color theme-color-red-sunglo" data-theme="red-sunglo">
                        <span class="theme-color-view"></span>
                        <span class="theme-color-name">Red Sunglo</span>
                      </li>
                      <li class="theme-color theme-color-red-intense" data-theme="red-intense">
                        <span class="theme-color-view"></span>
                        <span class="theme-color-name">Red Intense</span>
                      </li>
                      <li class="theme-color theme-color-purple-plum" data-theme="purple-plum">
                        <span class="theme-color-view"></span>
                        <span class="theme-color-name">Purple Plum</span>
                      </li>
                      <li class="theme-color theme-color-purple-studio" data-theme="purple-studio">
                        <span class="theme-color-view"></span>
                        <span class="theme-color-name">Purple Studio</span>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
              <div class="col-md-6 col-sm-6 col-xs-12 seperator">
                <h3>LAYOUT</h3>
                <ul class="theme-settings">
                  <li>
                    Theme Style
                    <select class="theme-setting theme-setting-style form-control input-sm input-small input-inline tooltips" data-original-title="Change theme style" data-container="body" data-placement="left">
                      <option value="boxed" selected="selected">Square corners</option>
                      <option value="rounded">Rounded corners</option>
                    </select>
                  </li>
                  <li>
                    Layout
                    <select class="theme-setting theme-setting-layout form-control input-sm input-small input-inline tooltips" data-original-title="Change layout type" data-container="body" data-placement="left">
                      <option value="boxed" selected="selected">Boxed</option>
                      <option value="fluid">Fluid</option>
                    </select>
                  </li>
                  <li>
                    Top Menu Style
                    <select class="theme-setting theme-setting-top-menu-style form-control input-sm input-small input-inline tooltips" data-original-title="Change top menu dropdowns style" data-container="body" data-placement="left">
                      <option value="dark" selected="selected">Dark</option>
                      <option value="light">Light</option>
                    </select>
                  </li>
                  <li>
                    Top Menu Mode
                    <select class="theme-setting theme-setting-top-menu-mode form-control input-sm input-small input-inline tooltips" data-original-title="Enable fixed(sticky) top menu" data-container="body" data-placement="left">
                      <option value="fixed">Fixed</option>
                      <option value="not-fixed" selected="selected">Not Fixed</option>
                    </select>
                  </li>
                  <li>
                    Mega Menu Style
                    <select class="theme-setting theme-setting-mega-menu-style form-control input-sm input-small input-inline tooltips" data-original-title="Change mega menu dropdowns style" data-container="body" data-placement="left">
                      <option value="dark" selected="selected">Dark</option>
                      <option value="light">Light</option>
                    </select>
                  </li>
                  <li>
                    Mega Menu Mode
                    <select class="theme-setting theme-setting-mega-menu-mode form-control input-sm input-small input-inline tooltips" data-original-title="Enable fixed(sticky) mega menu" data-container="body" data-placement="left">
                      <option value="fixed" selected="selected">Fixed</option>
                      <option value="not-fixed">Not Fixed</option>
                    </select>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
        <!-- END THEME PANEL -->
      </div>
      <!-- END PAGE TOOLBAR -->
    </div>
  </div>
  <!-- END PAGE HEAD -->
  <!-- BEGIN PAGE CONTENT -->
  <div class="page-content">
    <div class="container">
      <!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
      <div class="modal fade" id="portlet-config" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
              <h4 class="modal-title">Modal title</h4>
            </div>
            <div class="modal-body">
              Widget settings form goes here
            </div>
            <div class="modal-footer">
              <button type="button" class="btn blue">Save changes</button>
              <button type="button" class="btn default" data-dismiss="modal">Close</button>
            </div>
          </div>
          <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
      </div>
      <!-- /.modal -->
      <!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
      <!-- BEGIN PAGE BREADCRUMB -->
      <ul class="page-breadcrumb breadcrumb">
        <li>
          <a href="#">Home</a><i class="fa fa-circle"></i>
        </li>
        <li>
          <a href="table_managed.html">Extra</a>
          <i class="fa fa-circle"></i>
        </li>
        <li>
          <a href="table_managed.html">Data Tables</a>
          <i class="fa fa-circle"></i>
        </li>
        <li class="active">
          Managed Datatables
        </li>
      </ul>
      <!-- END PAGE BREADCRUMB -->
      <!-- BEGIN PAGE CONTENT INNER -->
      <div class="row">
        <div class="col-md-12">
          <!-- BEGIN EXAMPLE TABLE PORTLET-->
          <div class="portlet light">
            <div class="portlet-title">
              <div class="caption">
                <i class="fa fa-cogs font-green-sharp"></i>
                <span class="caption-subject font-green-sharp bold uppercase">Managed Table</span>
              </div>
              <div class="tools">
                <a href="javascript:;" class="collapse">
                </a>
                <a href="#portlet-config" data-toggle="modal" class="config">
                </a>
                <a href="javascript:;" class="reload">
                </a>
                <a href="javascript:;" class="remove">
                </a>
              </div>
            </div>
            <div class="portlet-body">
              <div class="table-toolbar">
                <div class="row">
                  <div class="col-md-6">
                    <div class="btn-group">
                      <button id="sample_editable_1_new" class="btn green">
                        Add New <i class="fa fa-plus"></i>
                      </button>
                    </div>
                  </div>
                  <div class="col-md-6">
                    <div class="btn-group pull-right">
                      <button class="btn dropdown-toggle" data-toggle="dropdown">Tools <i class="fa fa-angle-down"></i>
                      </button>
                      <ul class="dropdown-menu pull-right">
                        <li>
                          <a href="javascript:;">
                            Print </a>
                        </li>
                        <li>
                          <a href="javascript:;">
                            Save as PDF </a>
                        </li>
                        <li>
                          <a href="javascript:;">
                            Export to Excel </a>
                        </li>
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
              <table class="table table-striped table-bordered table-hover" id="sample_1">
                <thead>
                <tr>
                  <th class="table-checkbox">
                    <input type="checkbox" class="group-checkable" data-set="#sample_1 .checkboxes"/>
                  </th>
                  <th>
                    Username
                  </th>
                  <th>
                    Email
                  </th>
                  <th>
                    Points
                  </th>
                  <th>
                    Joined
                  </th>
                  <th>
                    Status
                  </th>
                </tr>
                </thead>
                <tbody>
                <tr class="odd gradeX">
                  <td>
                    <input type="checkbox" class="checkboxes" value="1"/>
                  </td>
                  <td>
                    shuxer
                  </td>
                  <td>
                    <a href="mailto:shuxer@gmail.com">
                      shuxer@gmail.com </a>
                  </td>
                  <td>
                    120
                  </td>
                  <td class="center">
                    12 Jan 2012
                  </td>
                  <td>
									<span class="label label-sm label-success">
									Approved </span>
                  </td>
                </tr>
                <tr class="odd gradeX">
                  <td>
                    <input type="checkbox" class="checkboxes" value="1"/>
                  </td>
                  <td>
                    looper
                  </td>
                  <td>
                    <a href="mailto:looper90@gmail.com">
                      looper90@gmail.com </a>
                  </td>
                  <td>
                    120
                  </td>
                  <td class="center">
                    12.12.2011
                  </td>
                  <td>
									<span class="label label-sm label-warning">
									Suspended </span>
                  </td>
                </tr>
                <tr class="odd gradeX">
                  <td>
                    <input type="checkbox" class="checkboxes" value="1"/>
                  </td>
                  <td>
                    userwow
                  </td>
                  <td>
                    <a href="mailto:userwow@yahoo.com">
                      userwow@yahoo.com </a>
                  </td>
                  <td>
                    20
                  </td>
                  <td class="center">
                    12.12.2012
                  </td>
                  <td>
									<span class="label label-sm label-success">
									Approved </span>
                  </td>
                </tr>
                <tr class="odd gradeX">
                  <td>
                    <input type="checkbox" class="checkboxes" value="1"/>
                  </td>
                  <td>
                    user1wow
                  </td>
                  <td>
                    <a href="mailto:userwow@gmail.com">
                      userwow@gmail.com </a>
                  </td>
                  <td>
                    20
                  </td>
                  <td class="center">
                    12.12.2012
                  </td>
                  <td>
									<span class="label label-sm label-default">
									Blocked </span>
                  </td>
                </tr>
                <tr class="odd gradeX">
                  <td>
                    <input type="checkbox" class="checkboxes" value="1"/>
                  </td>
                  <td>
                    restest
                  </td>
                  <td>
                    <a href="mailto:userwow@gmail.com">
                      test@gmail.com </a>
                  </td>
                  <td>
                    20
                  </td>
                  <td class="center">
                    12.12.2012
                  </td>
                  <td>
									<span class="label label-sm label-success">
									Approved </span>
                  </td>
                </tr>
                <tr class="odd gradeX">
                  <td>
                    <input type="checkbox" class="checkboxes" value="1"/>
                  </td>
                  <td>
                    foopl
                  </td>
                  <td>
                    <a href="mailto:userwow@gmail.com">
                      good@gmail.com </a>
                  </td>
                  <td>
                    20
                  </td>
                  <td class="center">
                    19.11.2010
                  </td>
                  <td>
									<span class="label label-sm label-success">
									Approved </span>
                  </td>
                </tr>
                <tr class="odd gradeX">
                  <td>
                    <input type="checkbox" class="checkboxes" value="1"/>
                  </td>
                  <td>
                    weep
                  </td>
                  <td>
                    <a href="mailto:userwow@gmail.com">
                      good@gmail.com </a>
                  </td>
                  <td>
                    20
                  </td>
                  <td class="center">
                    19.11.2010
                  </td>
                  <td>
									<span class="label label-sm label-success">
									Approved </span>
                  </td>
                </tr>
                <tr class="odd gradeX">
                  <td>
                    <input type="checkbox" class="checkboxes" value="1"/>
                  </td>
                  <td>
                    coop
                  </td>
                  <td>
                    <a href="mailto:userwow@gmail.com">
                      good@gmail.com </a>
                  </td>
                  <td>
                    20
                  </td>
                  <td class="center">
                    19.11.2010
                  </td>
                  <td>
									<span class="label label-sm label-success">
									Approved </span>
                  </td>
                </tr>
                <tr class="odd gradeX">
                  <td>
                    <input type="checkbox" class="checkboxes" value="1"/>
                  </td>
                  <td>
                    pppol
                  </td>
                  <td>
                    <a href="mailto:userwow@gmail.com">
                      good@gmail.com </a>
                  </td>
                  <td>
                    20
                  </td>
                  <td class="center">
                    19.11.2010
                  </td>
                  <td>
									<span class="label label-sm label-success">
									Approved </span>
                  </td>
                </tr>
                <tr class="odd gradeX">
                  <td>
                    <input type="checkbox" class="checkboxes" value="1"/>
                  </td>
                  <td>
                    test
                  </td>
                  <td>
                    <a href="mailto:userwow@gmail.com">
                      good@gmail.com </a>
                  </td>
                  <td>
                    20
                  </td>
                  <td class="center">
                    19.11.2010
                  </td>
                  <td>
									<span class="label label-sm label-success">
									Approved </span>
                  </td>
                </tr>
                <tr class="odd gradeX">
                  <td>
                    <input type="checkbox" class="checkboxes" value="1"/>
                  </td>
                  <td>
                    userwow
                  </td>
                  <td>
                    <a href="mailto:userwow@gmail.com">
                      userwow@gmail.com </a>
                  </td>
                  <td>
                    20
                  </td>
                  <td class="center">
                    12.12.2012
                  </td>
                  <td>
									<span class="label label-sm label-default">
									Blocked </span>
                  </td>
                </tr>
                <tr class="odd gradeX">
                  <td>
                    <input type="checkbox" class="checkboxes" value="1"/>
                  </td>
                  <td>
                    test
                  </td>
                  <td>
                    <a href="mailto:userwow@gmail.com">
                      test@gmail.com </a>
                  </td>
                  <td>
                    20
                  </td>
                  <td class="center">
                    12.12.2012
                  </td>
                  <td>
									<span class="label label-sm label-success">
									Approved </span>
                  </td>
                </tr>
                <tr class="odd gradeX">
                  <td>
                    <input type="checkbox" class="checkboxes" value="1"/>
                  </td>
                  <td>
                    goop
                  </td>
                  <td>
                    <a href="mailto:userwow@gmail.com">
                      good@gmail.com </a>
                  </td>
                  <td>
                    20
                  </td>
                  <td class="center">
                    12.11.2010
                  </td>
                  <td>
									<span class="label label-sm label-success">
									Approved </span>
                  </td>
                </tr>
                <tr class="odd gradeX">
                  <td>
                    <input type="checkbox" class="checkboxes" value="1"/>
                  </td>
                  <td>
                    weep
                  </td>
                  <td>
                    <a href="mailto:userwow@gmail.com">
                      good@gmail.com </a>
                  </td>
                  <td>
                    20
                  </td>
                  <td class="center">
                    15.11.2011
                  </td>
                  <td>
									<span class="label label-sm label-default">
									Blocked </span>
                  </td>
                </tr>
                <tr class="odd gradeX">
                  <td>
                    <input type="checkbox" class="checkboxes" value="1"/>
                  </td>
                  <td>
                    toopl
                  </td>
                  <td>
                    <a href="mailto:userwow@gmail.com">
                      good@gmail.com </a>
                  </td>
                  <td>
                    20
                  </td>
                  <td class="center">
                    16.11.2010
                  </td>
                  <td>
									<span class="label label-sm label-success">
									Approved </span>
                  </td>
                </tr>
                <tr class="odd gradeX">
                  <td>
                    <input type="checkbox" class="checkboxes" value="1"/>
                  </td>
                  <td>
                    userwow
                  </td>
                  <td>
                    <a href="mailto:userwow@gmail.com">
                      userwow@gmail.com </a>
                  </td>
                  <td>
                    20
                  </td>
                  <td class="center">
                    9.12.2012
                  </td>
                  <td>
									<span class="label label-sm label-default">
									Blocked </span>
                  </td>
                </tr>
                <tr class="odd gradeX">
                  <td>
                    <input type="checkbox" class="checkboxes" value="1"/>
                  </td>
                  <td>
                    tes21t
                  </td>
                  <td>
                    <a href="mailto:userwow@gmail.com">
                      test@gmail.com </a>
                  </td>
                  <td>
                    20
                  </td>
                  <td class="center">
                    14.12.2012
                  </td>
                  <td>
									<span class="label label-sm label-success">
									Approved </span>
                  </td>
                </tr>
                <tr class="odd gradeX">
                  <td>
                    <input type="checkbox" class="checkboxes" value="1"/>
                  </td>
                  <td>
                    fop
                  </td>
                  <td>
                    <a href="mailto:userwow@gmail.com">
                      good@gmail.com </a>
                  </td>
                  <td>
                    20
                  </td>
                  <td class="center">
                    13.11.2010
                  </td>
                  <td>
									<span class="label label-sm label-warning">
									Suspended </span>
                  </td>
                </tr>
                <tr class="odd gradeX">
                  <td>
                    <input type="checkbox" class="checkboxes" value="1"/>
                  </td>
                  <td>
                    kop
                  </td>
                  <td>
                    <a href="mailto:userwow@gmail.com">
                      good@gmail.com </a>
                  </td>
                  <td>
                    20
                  </td>
                  <td class="center">
                    17.11.2010
                  </td>
                  <td>
									<span class="label label-sm label-success">
									Approved </span>
                  </td>
                </tr>
                <tr class="odd gradeX">
                  <td>
                    <input type="checkbox" class="checkboxes" value="1"/>
                  </td>
                  <td>
                    vopl
                  </td>
                  <td>
                    <a href="mailto:userwow@gmail.com">
                      good@gmail.com </a>
                  </td>
                  <td>
                    20
                  </td>
                  <td class="center">
                    19.11.2010
                  </td>
                  <td>
									<span class="label label-sm label-success">
									Approved </span>
                  </td>
                </tr>
                <tr class="odd gradeX">
                  <td>
                    <input type="checkbox" class="checkboxes" value="1"/>
                  </td>
                  <td>
                    userwow
                  </td>
                  <td>
                    <a href="mailto:userwow@gmail.com">
                      userwow@gmail.com </a>
                  </td>
                  <td>
                    20
                  </td>
                  <td class="center">
                    12.12.2012
                  </td>
                  <td>
									<span class="label label-sm label-default">
									Blocked </span>
                  </td>
                </tr>
                <tr class="odd gradeX">
                  <td>
                    <input type="checkbox" class="checkboxes" value="1"/>
                  </td>
                  <td>
                    wap
                  </td>
                  <td>
                    <a href="mailto:userwow@gmail.com">
                      test@gmail.com </a>
                  </td>
                  <td>
                    20
                  </td>
                  <td class="center">
                    12.12.2012
                  </td>
                  <td>
									<span class="label label-sm label-success">
									Approved </span>
                  </td>
                </tr>
                <tr class="odd gradeX">
                  <td>
                    <input type="checkbox" class="checkboxes" value="1"/>
                  </td>
                  <td>
                    test
                  </td>
                  <td>
                    <a href="mailto:userwow@gmail.com">
                      good@gmail.com </a>
                  </td>
                  <td>
                    20
                  </td>
                  <td class="center">
                    19.12.2010
                  </td>
                  <td>
									<span class="label label-sm label-success">
									Approved </span>
                  </td>
                </tr>
                <tr class="odd gradeX">
                  <td>
                    <input type="checkbox" class="checkboxes" value="1"/>
                  </td>
                  <td>
                    toop
                  </td>
                  <td>
                    <a href="mailto:userwow@gmail.com">
                      good@gmail.com </a>
                  </td>
                  <td>
                    20
                  </td>
                  <td class="center">
                    17.12.2010
                  </td>
                  <td>
									<span class="label label-sm label-success">
									Approved </span>
                  </td>
                </tr>
                <tr class="odd gradeX">
                  <td>
                    <input type="checkbox" class="checkboxes" value="1"/>
                  </td>
                  <td>
                    weep
                  </td>
                  <td>
                    <a href="mailto:userwow@gmail.com">
                      good@gmail.com </a>
                  </td>
                  <td>
                    20
                  </td>
                  <td class="center">
                    15.11.2011
                  </td>
                  <td>
									<span class="label label-sm label-success">
									Approved </span>
                  </td>
                </tr>
                </tbody>
              </table>
            </div>
          </div>
          <!-- END EXAMPLE TABLE PORTLET-->
        </div>
      </div>
      <!-- END PAGE CONTENT INNER -->
    </div>
  </div>
  <!-- END PAGE CONTENT -->
</div>
<!-- END PAGE CONTAINER -->