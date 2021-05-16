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
          <th>제목</th>
          <th>작성자</th>
          <th>날짜</th>
        </tr>
        <list-row
          v-for="(item, index) in list"
          :key="`${index}_list`"
          :no="item.no"
          :title="item.title"
          :writer="item.writer"
          :regtime="item.regtime"
        />
        
      </table>
    </div>
    <div v-else>글이 없습니다.</div>
    <div class="text-right">
      <!-- <button class="btn btn-primary" @click="movePage">등록</button> -->
    </div>
    </div>
</template>

<script>
// import http from '@/util/http-common';
import axios from 'axios';
import ListRow from '@/components/Row.vue';
export default {
    name: 'list',
    components: {
        ListRow
    },
    data() {
        return {
            list: '',
        }
    },
    created() {
        axios.get("http://localhost:9999/vue/api/board")
        .then((resp) => {
            this.list = resp.data;
            console.log(resp);
        })
    }
}
</script>

<style>

</style>