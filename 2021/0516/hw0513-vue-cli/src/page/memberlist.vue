<template>
    <div>
        <div v-if="list.length">
      <table class="table table-bordered table-condensed">
        <colgroup>
          <col :style="{ width: '5%' }" />
          <col :style="{ width: '50%' }" />
          <col :style="{ width: '10%' }" />
          <col :style="{ width: '25%' }" />
        </colgroup>
        <tr>
          <th>번호</th>
          <th>이름</th>
          <th>직급</th>
          <th>월급</th>
          <th>부서</th>
        </tr>
        <tr v-for="(item,index) in list" :key="`${index}`">
          <td>{{item.id}}</td>
          <td>
            <router-link :to="`/member/read/${item.id}`">{{item.name}}</router-link>
          </td>
          <td>{{item.title}}</td>
          <td>{{item.salary}}</td>
          <td>{{item.deptName}}</td>
        </tr>
      </table>
    </div>
    <div v-else>회원이 없습니다.</div>
    <div class="text-right">
      <!-- <button class="btn btn-primary" @click="movePage">등록</button> -->
    </div>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    name: 'list',
    components: {
        
    },
    data() {
        return {
            list: '',
        }
    },
    created() {
        axios.get("http://localhost:9998/bootemp/employeeList")
        .then((resp) => {
            this.list = resp.data;
            console.log(resp);
        })
    }
}
</script>

<style>

</style>