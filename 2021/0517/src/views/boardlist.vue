<template>
  <div>
    <h2>게시판 목록??</h2>
    <table border="1">
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>날짜</th>
        <td>{{ yangyu }}</td>
      </tr>
      <tr v-for="(item, index) in boards" :key="`${index}`">
        <td>{{ item.no }}</td>
        <td>{{ item.title }}</td>
        <td>{{ item.writer }}</td>
        <td>{{ item.regtime }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  name: "boardlist",
  computed: {
    ...mapGetters(["boards"]),
    yangyu() {
      return "zzz";
    },
  },
  created() {
    console.log("zz");
    this.$store.dispatch("getBoards");
    console.log("boardList created() : " + this.boards);
  },
  methods: {},
};
</script>

<style></style>
