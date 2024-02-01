const Post = ({ id, title, author, getPost }) => {
  /*const getPost = (id) => {
    const post = posts.find((post) => post.id === id)
    console.log(post.information)
    setContent(post.information)
  }*/
  return (
    <div className="post" onClick={() => getPost(id)}>
      <p>Id: {id}</p>
      <p>Title: {title}</p>
      <p>Author: {author}</p>
    </div>
  )
}
export default Post
