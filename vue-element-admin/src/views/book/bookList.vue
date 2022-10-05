<template>
  <div>
    <!-- 搜索框区域 -->
    <el-row>
      <el-form
        :inline="true"
        :model="searchForm"
        ref="searchForm"
      >
        <el-form-item label="图书出版日期" prop="publishDate">
          <el-date-picker
            v-model.trim="searchDate"
            type="datetimerange"
            range-separator="至"
            @change="dateChange()"
            value-format="yyyy-MM-dd HH:mm:ss"
            start-placeholder="开始日期"
            end-placeholder="结束日期"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="书名" prop="bookName">
            <el-input v-model.trim="searchForm.bookName" placeholder="书名"></el-input>
        </el-form-item>
        <el-form-item label="作者" prop="bookAuthor">
            <el-input v-model.trim="searchForm.bookAuthor" placeholder="作者"></el-input>
        </el-form-item>
        <el-form-item label="出版社" prop="bookPublisher">
            <el-input v-model.trim="searchForm.bookPublisher" placeholder="出版社"></el-input>
        </el-form-item>
        <el-form-item label="分类" prop="bookCategory">
            <el-input v-model.trim="searchForm.bookCategory" placeholder="分类"></el-input>
        </el-form-item>
      </el-form>
    </el-row>
    <!-- 按钮区域 -->
    <el-row></el-row>
    <!-- 表单区域 -->
    <el-table
      :data="tableData"
      border
      style="width: 100%"
      @selection-change="handleSelectionChange"
    >
    <el-table-column type="selection" width="40"></el-table-column>

    <el-table-column prop="bookName" label="书名"></el-table-column>
    <th width="40">书名</th>

    <el-table-column prop="bookAuthor" label="作者名"></el-table-column>
    <th width="40">作者名</th>

    <el-table-column prop="bookPublisher" label="出版社"></el-table-column>
    <th width="40">出版社</th>

    <el-table-column prop="bookCategory" label="图书分类"></el-table-column>
    <th width="40">图书分类</th>

    <el-table-column prop="publishDate" label="出版日期" value-format="yyyy-MM-dd"></el-table-column>
    <th width="40">出版日期</th>

    <el-table-column prop="totalNum" label="总库存量"></el-table-column>
    <th width="40">总库存量</th>


    <el-table-column prop="surplusNum" label="剩余量"></el-table-column>
    <th width="40">剩余量</th>


    </el-table>
    <!-- 表格分页操作 -->
    <el-pagination
      :current-page="currentPage"
      :page-size="pageSize"
      @current-change="handleCurrentChange"
      background
      layout="prev, pager, next"
      :total="totalCount"
    >
    </el-pagination>
  </div>
</template>
<script>
  import { list } from '../../api/book.js';
  export default {
    data() {
      return {
        //搜索框输入时间
        searchDate: "",
        //表单数据
        tableData: [],
        //批量删除时表单被选中的行
        rowChecked: "",
        //分页所需变量：当前页码 每页数据条目限制
        currentPage: 1,
        pageSize: 10,
        dataForm: {
          id: "",
          bookName: "",
          bookAuthor: "",
          bookPublisher: "",
          bookCategory: "",
          bookIntroduction: "",
          publishDate: "",
          totalNum: "",
          surplusNum: "",
        },
        //搜索框数据
        searchForm: {
          bookName: "",
          bookAuthor: "",
          bookPublisher: "",
          bookCategory: "",
          beginTime: "",
          endTime: ""
        },
      }
    },
    created: function () {
    	this.list(this.$data.currentPage, this.$data.pageSize, this.$data.dataForm);
    },
    methods: {
      //表单查询方法
      list(currentPage, pageSize, dataForm) {
        list(currentPage, pageSize, dataForm).then(response => {
          console.info(response);
          this.$data.tableData = response.records;
        })
      },
      //日期更改方法
      dateChange: function () {
        this.searchForm.beginTime = this.searchDate[0];
        this.searchForm.endTime = this.searchDate[1];
      },
      //表格选定行
      handleSelectionChange: function (val) {
        this.tableChecked = val;
      },
      //表格选定页
      handleCurrentChange: function (val) {
        this.$data.currentPage = val;
        this.pageList();
      },
    }
  }
</script>
