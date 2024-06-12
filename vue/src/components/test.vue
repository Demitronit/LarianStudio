<template>
    <div>
      <input type="text" v-model="searchQuery" @input="searchGame" placeholder="Введите название игры">
      <ul v-if="games.length">
        <li v-for="game in games" :key="game.id">
          {{ game.name }} - {{ game.description }}
        </li>
      </ul>
      <p v-else>Нет результатов</p>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    data() {
      return {
        searchQuery: '',
        games: []
      };
    },
    methods: {
      searchGame() {
        axios.get(/api/games?search=${this.searchQuery})
          .then(response => {
            this.games = response.data;
          })
          .catch(error => {
            console.error('Ошибка при получении данных игры', error);
          });
      }
    }
  };
  </script>
  