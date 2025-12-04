
let games = [
  { id: 1, title: "FIFA 25", genre: "Deportes", price: 49990 },
  { id: 2, title: "Call of Duty", genre: "Shooter", price: 59990 },
  { id: 3, title: "Resident Evil 4", genre: "Horror", price: 39990 }
];


let nextId = 4;

function getAllGames() {
  return games;
}

function getGameById(id) {
  return games.find(g => g.id === id);
}

function createGame(data) {
  const newGame = {
    id: nextId++,
    title: data.title,
    genre: data.genre,
    price: data.price
  };
  games.push(newGame);
  return newGame;
}

function updateGame(id, data) {
  const index = games.findIndex(g => g.id === id);
  if (index === -1) return null;

  games[index] = {
    ...games[index],
    title: data.title ?? games[index].title,
    genre: data.genre ?? games[index].genre,
    price: data.price ?? games[index].price
  };

  return games[index];
}

function deleteGame(id) {
  const index = games.findIndex(g => g.id === id);
  if (index === -1) return false;

  games.splice(index, 1);
  return true;
}

module.exports = {
  getAllGames,
  getGameById,
  createGame,
  updateGame,
  deleteGame
};
