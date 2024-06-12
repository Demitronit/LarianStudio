<script>
export default {
  data() {
    return {
      gameName: '',
      game: null,
      error: ''
    };
  },
  methods: {
    async searchGame() {
      let gameId;
      if (this.gameName === 'Baldurs Gate 3') {
        gameId = 1;
      } else if (this.gameName === 'Divinity 2') {
        gameId = 2;
      } else if (this.gameName === 'Divinity Origin Sin 2') {
        gameId = 3;
      } else {
        this.error = 'Игра не найдена';
        this.game = null;
        return;
      }

      try {
        const response = await fetch(`http://localhost:8080/game/${gameId}`);

        if (!response.ok) {
          throw new Error(`Ошибка сети: ${response.statusText}`);
        }

        const contentType = response.headers.get('content-type');
        if (!contentType || !contentType.includes('application/json')) {
          throw new Error('Получен некорректный ответ, ожидается JSON');
        }

        const data = await response.json();
        this.game = data;
        this.error = '';
      } catch (error) {
        this.error = 'Ошибка: ' + error.message;
        this.game = null;
      }
    }
  }
};
</script>
<template>
  <div class="menu">
    <div>
      <img class="iconuser" src="@/assets/user.png" alt="">
      <div class="info">
      </div>
    </div>
    <div>
      <p class="text">Здравствуй!</p>
    </div>
  <div>
    <div>
      <input v-model="gameName" placeholder="Введите название игры" />
      <button @click="searchGame">Поиск</button>
    </div>
    <div class="gamebar">
      <div v-if="game">
        <h2>{{ game.name }}</h2>
        <p>{{ game.cost }}</p>
        <p>{{ game.information }}</p>
      </div>
      <div v-else-if="error">
        <p>{{ error }}</p>
      </div>
    </div>
    </div>
    </div>

</template>

<style>
.gamebar{
  background-color: azure;
}
.menu{
  display: flex;
  justify-content: space-between;
}
.iconuser{
    height: 250px;
    margin-left: 20px;
}
.info{
    margin-top: 50px;
    margin-left: 20px;
}
.text{
    color: rgb(11, 126, 30);
    background-color: azure;
}

</style>