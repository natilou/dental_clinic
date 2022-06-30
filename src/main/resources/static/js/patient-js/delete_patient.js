function deleteBy(id){

  const url = '/patients/'+ id;
  const settings = {
    method: 'DELETE'
  }

  fetch(url,settings)
  .then(response => response.json())
  .then(() => {
    let row_id = "#tr_" + id;
    document.querySelector(row_id).remove();
  })
  location.reload();
}