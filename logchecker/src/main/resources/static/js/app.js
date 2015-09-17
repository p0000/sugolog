/** @jsx React.DOM */

var converter = new Showdown.converter();

var Comment = React.createClass({
    render: function() {
        var rawMarkup = converter.makeHtml(this.props.children.toString());
        return (
            <div class="comment">
                <h2 class="commentAuthor">{this.props.author}</h2>
                <span dangerouslySetInnerHTML={{__html: rawMarkup}} />
            </div>
            );
    }
});

var CommentBox = React.createClass({
    loadCommentsFromServer: React.autoBind(function() {
        $.ajax({
            url: this.props.url,
            success: function(data) {
                this.setState({data: data});
            }.bind(this)
        });
    }),
    handleCommentSubmit: React.autoBind(function(comment) {
        var comments = this.state.data;
        comments.push(comment);
        this.setState({data: comments});
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            url: this.props.url,
            type: 'POST',
            dataType: "json",
            data: JSON.stringify(comment),
            success: function(data) {
                this.setState({data: data});
            }.bind(this)
        });
    }),
    getInitialState: function() {
        return {data: []};
    },
    componentDidMount: function() {
        this.loadCommentsFromServer();
        setInterval(this.loadCommentsFromServer, this.props.pollInterval);
    },
    render: function() {
        return (
            <div class="commentBox">
                <h1>Comments</h1>
                <CommentForm onCommentSubmit={this.handleCommentSubmit} />
                <CommentList data={this.state.data} />
            </div>
            );
    }
});

var CommentList = React.createClass({
    render: function() {
        var commentNodes = this.props.data.map(function (comment) {
            return <Comment author={comment.author}>{comment.text}</Comment>;
        });
        return <div class="commentList">{commentNodes}</div>;
    }
});

var CommentForm = React.createClass({
    handleSubmit: React.autoBind(function() {
        var author = this.refs.author.getDOMNode().value.trim();
        var text = this.refs.text.getDOMNode().value.trim();
        if (text.length === 0 || author.length === 0) {
            return false;
        }
        this.props.onCommentSubmit({author: author, text: text});
        this.refs.author.getDOMNode().value = '';
        this.refs.text.getDOMNode().value = '';
        return false;
    }),
    render: function() {
        return (
            <form className="commentForm" onSubmit={this.handleSubmit}>
                <input type="text" placeholder="Your name" ref="author" />
                <input type="text" placeholder="Say something..." ref="text" />
                <input type="submit" value="Post" />
            </form>
            );
    }
});

React.renderComponent(
    <CommentBox url="/comments" pollInterval={2000} />,
    document.getElementById('container')
);