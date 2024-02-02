import { useDashboardContext } from '../Dashboard'

const PostDetails = () => {
  const { content } = useDashboardContext()

  return <div className="content">{content}</div>
}
export default PostDetails
