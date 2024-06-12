<script setup>
import Header from '@/components/Header.vue';
import MainBody from '@/components/MainBody.vue';
import Footer from '@/components/Footer.vue';
</script>

<template>
  <div class="fon">
    <Header /><router-view></router-view>
    <MainBody /><router-view></router-view>
    <Footer /><router-view></router-view>

  </div>
</template>

<style scoped>
.fon{
  background: url(../assets/back.jpg) no-repeat;
  background-size: 100%;
  
}
</style>



