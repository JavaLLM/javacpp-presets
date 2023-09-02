def escape_string(text):
    text = text.replace("\\", "\\\\")
    text = text.replace("\n", "\\n")
    text = text.replace("\"", "\\\"")
    return text


def format_to_objc_string(text):
    text = escape_string(text)
    objc_string = "@\"" + text + "\""
    return objc_string


with open('/Users/pengym/Projects/JavaLLM/javacpp-presets/llamacpp/cppbuild/macosx-arm64/llama.cpp-b1112/ggml-metal.metal', 'r') as file:
    contentA = file.read()

escaped_contentA = escape_string(contentA)
print(escaped_contentA)
