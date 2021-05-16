<template>
  <div>
      <h3>삭제 중입니다.</h3>
  </div>
</template>

<script>
import axios from 'axios';
export default {
    name: "delete",
    created() {
        axios.delete(`http://localhost:9998/bootemp/employee/${this.$route.params.id}`)
        .then(({data}) => {
            let msg = '삭제 처리시 문제가 발생했습니다.';
            if (data === 'success') {
                msg = '삭제가 완료되었습니다.';
            }
            alert(msg);
            this.$router.push('/member/list');
        }).catch(() => {
            alert('삭제 처리시 에러가 발생했습니다.');
            this.$router.push('/member/list');
        });
    }
}
</script>

<style>

</style>