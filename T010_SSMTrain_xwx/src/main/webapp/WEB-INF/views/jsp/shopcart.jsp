<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String root = request.getContextPath();
    System.err.println("root = " + root);%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>shopCar</title>
    <link rel="stylesheet" type="text/css" href="<%=root%>/plug-in/bootstrap-3.4.0-dist/css/bootstrap.min.css"/>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/vue@2.5.16/dist/vue.js"></script>
    <style>
        * {
            margin: 0;
            padding: 0;
            border: 0;
        }

        body {
            background: #eee;
        }

        table {
            background: #fff;
            text-align: center;
        }

        table img {
            width: 40px;
            height: 40px;
        }

        table i {
            font-style: normal;
            color: red;
            padding: 0 5px;
        }

        table td * {
            vertical-align: middle;
        }

        table th {
            text-align: center;
        }

        .glyphicon {
            cursor: pointer;
        }

        .red {
            color: red;
        }

        .fx {
            text-decoration: underline;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="container" id="shopCar">
    <h1>购物清单</h1>
    <table class="table">
        <tr>
            <!-- .glyphicon .glyphicon-ok-circle -->
            <th>
                <label>
                    全选
                    <span class="glyphicon glyphicon-unchecked" @click="selectAll" v-show="!saremark"/></span>
                    <span class="glyphicon glyphicon-ok-circle" @click="selectAll" v-show="saremark"/></span>
                </label>/
                <label for="" class="fx" @click="selectInverse">
                    反选
                </label>
            </th>
            <th>商品</th>
            <th>数量</th>
            <th>单价</th>
            <th>金额</th>
            <th>操作</th>
        </tr>
        <tr v-for="(item,itemIndex) in goodLists">
            <td>
                <span class="glyphicon glyphicon-unchecked" @click="selectItem(itemIndex)"
                      v-show="!item.isSelect">
                </span>
                <span class="glyphicon glyphicon-ok-circle" @click="selectItem(itemIndex)"
                      v-show="item.isSelect"></span>
            </td>
            <td v-text="item.goods"></td>
            <td>
						<span class="btn-group btn-group-sm">
						    <button type="button" class="btn btn-default"
                                    @click="addNumbers(item.numbers,itemIndex)">+</button>
						    <button type="button" class="btn btn-default">{{item.numbers}}</button>
						    <button type="button" class="btn btn-default" @click="minusNumbers(item.numbers,itemIndex)">-</button>
						</span>
            </td>
            <td class="red" v-text="item.price"></td>
            <td class="red" v-text="item.price * item.numbers"></td>
            <td><a href="javascript:;" class="delete" @click="deleteItem(itemIndex)">删除</a></td>
        </tr>
        <tr>
            <td><a href="javascript:;" class="glyphicon glyphicon-trash" @click="deleteChecked">删除</a></td>
            <td class="text-right" colspan="5">
                <span class="glyphicon glyphicon-shopping-cart">:</span>
                <i>{{nTotal}}</i>件商品共计：<i class="glyphicon glyphicon-usd">{{pTotal}}</i>
                <button type="button" class="btn btn-danger">去结算</button>
            </td>
        </tr>
    </table>
</div>
<script type="text/javascript">
    var goodList = [
        {isSelect: false, goods: "0牛奶", numbers: "1", price: '5', total: '0'},
        {isSelect: false, goods: "1豆腐", numbers: "1", price: '10', total: '0'},
        {isSelect: false, goods: "2卤蛋", numbers: "1", price: '3', total: '0'},
        {isSelect: false, goods: "3饼干", numbers: "1", price: '4', total: '0'},
        {isSelect: false, goods: "4糖果", numbers: "1", price: '1', total: '0'}
    ];
    var shopCar = new Vue({
        el: "#shopCar",
        data: {
            goodLists: goodList,  //商品列表
            saremark: false,  //全选按钮判断
            nTotal: 0,  //总个数
            pTotal: 0,  //总价格
            checked: []  //记录哪些item被选中
        },
        watch: {
            goodLists: {
                handler: function (val, oldVal) {  //深度监听goodLists，修改总个数及总价格
                    var _this = this, nTotal = 0, pTotal = 0, checked = [], isSelectAll = true;
                    _this.goodLists.map(function (i) {
                        if (i.isSelect) {  //计算选中的总个数和总价格,选中状态
                            nTotal += parseInt(i.numbers);
                            pTotal += parseInt(i.price) * parseInt(i.numbers);
                        } else {
                            isSelectAll = false;
                            checked.push(i);  //非选中项存入checked数组，deleteChecked方法使用
                        }
                    });
                    _this.nTotal = nTotal;
                    _this.pTotal = pTotal;
                    _this.checked = checked;
                    _this.saremark = isSelectAll ? true : false;
                    if (this.goodLists.length == 0) {
                        _this.saremark = false;
                    }
                },
                deep: true
            }
        },
        methods: {
            selectAll: function () {  //全选
                var _this = this;
                _this.saremark = !_this.saremark;
                goodList.forEach(function (v, i) {
                    v.isSelect = _this.saremark;
                });
            },
            selectInverse: function () {  //反选
                var _this = this;
                _this.goodLists.forEach(function (v, i) {
                    v.isSelect = !v.isSelect;
                });
            },
            selectItem: function (i) {  //选择当前行
                this.saremark = false;
                this.goodLists[i].isSelect = !this.goodLists[i].isSelect;
            },
            addNumbers: function (n, i) {  //增加数量
                n++;
                Vue.set(this.goodLists[i], "numbers", n);
            },
            minusNumbers: function (n, i) {  //减少数量
                n = n <= 0 ? 0 : n - 1;
                Vue.set(this.goodLists[i], "numbers", n);
            },
            deleteItem: function (i) {  //删除当前行
                this.goodLists.splice(i, 1);
            },
            deleteChecked: function () {  //删除选中的item
                if (this.checked.length == 0 && this.saremark) {
                    this.goodLists = this.checked;
                } else if (this.checked.length != 0) {
                    this.goodLists = this.checked;
                }
            }
        }
    });
</script>
</body>
</html>
